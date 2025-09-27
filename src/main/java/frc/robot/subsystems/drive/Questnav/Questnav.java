package frc.robot.subsystems.drive.Questnav;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Questnav extends SubsystemBase {
  private final QuestnavIO IO;
  private final QuestnavIOInputsAutoLogged
      input; // need to make this an autologged class but I don't know how to fix that

  public Questnav(
      QuestnavIO IO, QuestnavIOInputsAutoLogged input) { // same as what I said above but here
    this.IO = IO;
    this.input = input;
  }

  @Override
  public void periodic() {
    IO.commandPeriodic();
    IO.updateInputs(input);
    Logger.processInputs("QuestNav", input);

    // add alerts

  }

  public boolean isTrustworthy() {
    return (input.isConnected && input.latency < 10 && input.frameCount > 60 && input.tracking);
  }
}
