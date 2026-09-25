
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;

public class Auto extends Command {
  public static final Timer milena = new Timer();
  public final drivetrain drive;
  public final locomo locomo;

  public Auto(drivetrain subsistem , locomo locomo) {
    this.locomo = locomo;
    this.drive = subsistem;
    addRequirements(subsistem);
  }

  @Override
  public void initialize() {
    milena.reset();
    milena.start();
  }

  @Override
  public void execute() {
    if(milena.get() > 0  && milena.get() < 2){
      drive.drive(0.5, 0.5);
    }

    else{
      drive.drive(0, 0);
      milena.stop(); milena.reset();
    }
    
  locomo.dashboard();
  }

  @Override
  public void end(boolean interrupted) {
 
  }

  @Override
  public boolean isFinished() {
    if (milena.get() >= 2.1){
      return true;
    }
    return false;
  }
}
