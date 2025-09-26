package frc.robot.subsystems.drive.Questnav;

import java.util.OptionalInt;

import org.littletonrobotics.junction.AutoLog;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public interface QuestnavIO{
    @AutoLog
public static class QuestnavIOInputs {
public boolean isConnected = false; // give error if this is false and don't accept estimations to the averager
public OptionalInt batteryPercent; // give error if this is too low
public boolean tracking; // error if false
public OptionalInt frameCount; // error if it gets too low and don't accept estimations to the averager
public OptionalInt trackingLostCount; // log this
public double latency; // error if it gets too high and don't accept estimations to the averager
public double[] appTimestamps = new double[] {}; // log this
public boolean isTrustworthy = false;
public Pose2d estimatedPoseFieldCentric;
public Pose2d estimatedPoseRobotCentric;
public Rotation2d estimatedRotation;
    }
public default void updateInputs(QuestnavIOInputs inputs) {}
public default void commandPeriodic() {}
}
