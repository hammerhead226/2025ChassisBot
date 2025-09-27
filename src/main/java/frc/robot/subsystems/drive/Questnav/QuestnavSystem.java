package frc.robot.subsystems.drive.Questnav;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import gg.questnav.questnav.PoseFrame;
import gg.questnav.questnav.QuestNav;

public class QuestnavSystem implements QuestnavIO {
  public QuestNav headset;
  Transform2d questRobotPose;
  Pose2d estimatedRobotPose;
  Rotation2d estimatedRobotRotation;

  public QuestnavSystem() {
    headset = new QuestNav();
    questRobotPose = new Transform2d(); // add quest's x,y and rotational offset from robot
    estimatedRobotPose = new Pose2d();
    estimatedRobotRotation = new Rotation2d();
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
      estimatedRobotPose = questPose.transformBy(questRobotPose.inverse());

      inputs.estimatedRobotPose = estimatedRobotPose;
      inputs.estimatedRotation = questPose.transformBy(questRobotPose.inverse()).getRotation();
    }
  }

  @Override
  public void commandPeriodic() {
    headset.commandPeriodic();
  }
}
