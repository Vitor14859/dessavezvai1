package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;

public class Auto extends Command {
  public static final Encoder loui = new Encoder(Constants.encodercanais.autoA, Constants.encodercanais.autoB  );
  public final drivetrain drive;
  public final locomo locomo;

  public Auto(drivetrain subsistem , locomo locomo) {
    this.locomo = locomo;
    this.drive = subsistem;
    addRequirements(subsistem);
  }

  @Override
  public void initialize() {
    loui.reset();
  }

  @Override
  public void execute() {

    if(loui.getDistance() >= 0 && loui.getDistance() < 12){
      drive.drive(0.5, 0.5);
    }

    else{
      drive.drive(0, 0);
      loui.reset();
    }
  
  loui.setDistancePerPulse(4.0 / 256.0);
  locomo.dashboard();
  }

  @Override
  public void end(boolean interrupted) {
 
    
  }

  @Override
  public boolean isFinished() {
    if (loui.getDistance() >= 13){
      return true;
    }
    return false;
  }
}