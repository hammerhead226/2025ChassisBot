package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.drive.Drive;

public class JoystickDrive extends Command {
    private Drive drive;
    private DoubleSupplier xSupplier;
    private DoubleSupplier ySupplier;
    private DoubleSupplier omegaSupplier;

    public JoystickDrive(
        Drive drive,
        DoubleSupplier xSupplier,
        DoubleSupplier ySupplier,
        DoubleSupplier omegaSupplier
    ) {
        this.drive = drive;
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.omegaSupplier = omegaSupplier;
    }

    @Override
    public void execute() {

    }
}
