package frc.robot.util;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldMirroring {
    public static boolean shouldApply() {
        final Optional<DriverStation.Alliance> alliance = DriverStation.getAlliance();
        return alliance.isPresent() && alliance.get().equals(DriverStation.Alliance.Red);
    }
}
