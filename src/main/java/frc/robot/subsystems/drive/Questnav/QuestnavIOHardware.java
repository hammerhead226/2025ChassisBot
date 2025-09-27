package frc.robot.subsystems.drive.Questnav;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import gg.questnav.questnav.PoseFrame;
import gg.questnav.questnav.QuestNav;

public class QuestnavIOHardware implements QuestnavIO {
  public QuestNav headset;
  Transform2d questRobotPose;
  Rotation2d estimatedRobotRotation;

  public QuestnavIOHardware() {
    headset = new QuestNav();
    questRobotPose = new Transform2d(1.0,1.0,new Rotation2d(5)); // add quest's x,y and rotational offset from robot these are temporary values
  }

  @Override
  public void updateInputs(QuestnavIOInputs inputs) {
    inputs.isConnected = headset.isConnected();
    inputs.latency = headset.getLatency();
    inputs.batteryPercent = headset.getBatteryPercent().getAsInt();
    inputs.frameCount = headset.getFrameCount().getAsInt();
    inputs.tracking = headset.isTracking();
    inputs.trackingLostCount = headset.getTrackingLostCounter().getAsInt();

    PoseFrame[] poseFrames = headset.getAllUnreadPoseFrames();

    if (poseFrames.length > 0) {
      // Get the most recent Quest pose
      Pose2d questPose = poseFrames[poseFrames.length - 1].questPose();

      // Transform by the mount pose to get your robot pose
      inputs.estimatedRobotPose = questPose.transformBy(questRobotPose.inverse());
      inputs.estimatedRotation = questPose.transformBy(questRobotPose.inverse()).getRotation();
    }
  }

  @Override
  public void commandPeriodic() {
    headset.commandPeriodic();
  }
}
