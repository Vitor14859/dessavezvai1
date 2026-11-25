package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Calculos;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.encoder;

public class Auto extends Command {
  public final drivetrain drive;
  public final locomo locomo;
  private final encoder encoder;
  private final Calculos calculos = new Calculos();

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

    if(encoder.takeDistance() > 0 && encoder.takeDistance() < (Calculos.volta*  2)){
      drive.drive(0.2, 0.2);
    }

    else{
      drive.drive(0, 0);
      encoder.reset();
    }
  
  locomo.dashboard();
  calculos.encoder_calculo();
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