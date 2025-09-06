// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static edu.wpi.first.units.Units.Meters;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.RotationTarget;
import com.pathplanner.lib.path.Waypoint;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.vision.Vision;
import java.util.ArrayList;
import java.util.List;
import org.littletonrobotics.junction.Logger;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutoAligntoAprilTag extends Command {
  /** Creates a new AutoAligntoAprilTag. */
  private final Drive drive;

  private final Vision vision;

  Command pathCommand;

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
    Pose2d tagPose = Constants.FieldConstants.TAG_POSES[6].toPose2d();
    Pose2d endPose =
        DriveCommands.rotateAndNudge(
            tagPose, new Translation2d(Meters.of(-0.30), Meters.of(0.00)), Rotation2d.k180deg);
    Logger.recordOutput("endPose", endPose);

    List<RotationTarget> holomorphicRotations = new ArrayList<>();
    // Arrays.asList(new RotationTarget(0.5, Rotation2d.kZero));

    List<Waypoint> waypoints = PathPlannerPath.waypointsFromPoses(startPose, endPose);

    PathPlannerPath path =
        new PathPlannerPath(
            waypoints,
            holomorphicRotations,
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(),
            new PathConstraints(1, 2, Math.toRadians(150), Math.toRadians(250)),
            null,
            new GoalEndState(0, endPose.getRotation()),
            isScheduled());
    path.preventFlipping = true;

    pathCommand = AutoBuilder.followPath(path);
    pathCommand.initialize();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pathCommand.execute();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pathCommand.cancel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pathCommand.isFinished();
  }
}
