  
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;


public class RobotContainer {
  private static final Joystick  sim = new Joystick(OperatorConstants.sim);
  private static drivetrain drivetrain = new drivetrain();
  public RobotContainer() {
    drivetrain();
    
  } 
  private void drivetrain(){
    drivetrain = new drivetrain();
  }
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}


