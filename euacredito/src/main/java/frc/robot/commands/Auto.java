package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.encoder;

public class Auto extends Command {
  public final drivetrain drive;
  public final locomo locomo;
  private final encoder encoder;

  public Auto(drivetrain subsistem , locomo locomo, encoder encoder) {
    this.locomo = locomo;
    this.drive = subsistem;
    this.encoder = encoder;
    addRequirements(subsistem, encoder);
  }

  @Override
  public void initialize() {
    encoder.reset();
  }

  @Override
  public void execute() {
 if (encoder.takeDistance() > Constants.AutoConstants.distanciaAlvo) {
      drive.drive(Constants.AutoConstants.velocidade, Constants.AutoConstants.velocidade);
    } else {
      drive.drive(0, 0);
    }
  
  
  locomo.dashboard();
  }

  @Override
  public void end(boolean interrupted) {
    drive.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return encoder.takeDistance() <= Constants.AutoConstants.distanciaAlvo;
  }
} 