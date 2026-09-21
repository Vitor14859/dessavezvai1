  
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.locomo;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Timer;

public class RobotContainer {
  public static final Joystick  sim = new Joystick(OperatorConstants.sim);
  public static final drivetrain drivetrain = new drivetrain();
  public static final locomo locomo = new locomo(sim, drivetrain);
  public static final Timer milena = new Timer();
  public RobotContainer() {
    locomo.addRequirements(drivetrain);
    drivetrain.setDefaultCommand(locomo);

  } 
  
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}



