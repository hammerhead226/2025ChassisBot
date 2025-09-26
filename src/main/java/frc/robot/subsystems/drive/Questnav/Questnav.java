package frc.robot.subsystems.drive.Questnav;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.Questnav.QuestnavIO.QuestnavIOInputs;
import gg.questnav.questnav.QuestNav;

public class Questnav extends SubsystemBase {
private final QuestnavIO IO;
private final QuestnavIOInputs input; // need to make this an autologged class but I don't know how to fix that
    public Questnav (QuestnavIO IO, QuestnavIOInputs input) { // same as what I said above but here
this.IO = IO;
this.input = input;
    }
    @Override
    public void periodic() {
IO.commandPeriodic();
IO.updateInputs(input);
Logger.recordOutput("Is Questnav Connected", input.isConnected);
Logger.recordOutput("Questnav time stamps", input.appTimestamps);
Logger.recordOutput("Is Questnav estimation trustworth", input.isTrustworthy);
Logger.recordOutput("Questnav latency", input.latency);
Logger.recordOutput("Is Questnav tracking(working)", input.tracking);
Logger.recordOutput("Questnav field centric pose estimation", input.estimatedPoseFieldCentric);
Logger.recordOutput("Questnav robot centric pose estimation", input.estimatedPoseRobotCentric);
Logger.recordOutput("Questnav battery percent", input.batteryPercent.getAsInt());
Logger.recordOutput("Questnav current frame rate", input.frameCount.getAsInt());
Logger.recordOutput("Is Questnav Connected", input.trackingLostCount.getAsInt());
Logger.recordOutput("Questnav estimated rotation", input.estimatedRotation);
// add alerts
    }
}
