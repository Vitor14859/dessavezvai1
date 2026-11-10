package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.encoder;

public class Auto extends Command {
  public final drivetrain drive;
  public final locomo locomo;

  private final encoder encoder = new encoder();

  public Auto(drivetrain subsistem , locomo locomo) {
    this.locomo = locomo;
    this.drive = subsistem;
    addRequirements(subsistem);
  }

  @Override
  public void initialize() {
    encoder.reset();
  }

  @Override
  public void execute() {

    if(encoder.takeDistance() >= 0 && encoder.takeDistance() < 12){
      drive.drive(0.5, 0.5);
    }

    else{
      drive.drive(0, 0);
      encoder.reset();
    }
  
  locomo.dashboard();
  }

  @Override
  public void end(boolean interrupted) {
 
    
  }

  @Override
  public boolean isFinished() {
    if (encoder.takeDistance() >= 13){
      return true;
    }
    return false;
  }
}