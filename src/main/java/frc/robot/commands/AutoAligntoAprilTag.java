// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.units.Units.Degrees;
import edu.wpi.first.units.Units.Meters;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.vision.Vision;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutoAligntoAprilTag extends Command {
  /** Creates a new AutoAligntoAprilTag. */
  private final Drive drive;

  private final Vision vision;

  public AutoAligntoAprilTag(Drive drive, Vision vision) {
    this.drive = drive;
    this.vision = vision;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive, vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Pose2d startPose = drive.getPose();
    Pose2d tagPose =
        new Pose2d(3.66, 4.33, new Rotation2d(Degrees.of(180.00)));
    Pose2d endPose =
        DriveCommands.rotateAndNudge(
            tagPose, new Translation2d(Meters.of(1.00), Meters.of(0.00)), Rotation2d.kZero);

    List<Waypoint> waypoints = PathPlannerPath.waypointsFromPoses(startPose, endPose);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
