package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(drivetrain subsystem) {
    return Commands.sequence(subsystem.methodcommand(),new locomo(subsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
