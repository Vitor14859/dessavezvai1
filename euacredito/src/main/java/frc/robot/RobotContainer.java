  
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Armcontrol;
import frc.robot.commands.Auto;
import frc.robot.commands.GarraControl;
import frc.robot.commands.locomo;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Garra;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  public static final Joystick  sim = new Joystick(OperatorConstants.sim);
  public static final drivetrain drivetrain = new drivetrain();
  public static final locomo locomo = new locomo(sim, drivetrain);
  public static final Arm arm = new Arm();
  public static final Armcontrol armcontrol = new Armcontrol(sim, arm);
  public static final Garra garra = new Garra();
  public static final GarraControl garracontrol= new GarraControl(garra, sim);

  public RobotContainer() {
    armcontrol.addRequirements(arm);
    arm.setDefaultCommand(armcontrol);
    locomo.addRequirements(drivetrain);
    drivetrain.setDefaultCommand(locomo);
    garracontrol.addRequirements(garra);
    garra.setDefaultCommand(garracontrol);

  } 
  
 public Command getAutonomousCommand() {
    return new Auto(drivetrain, locomo);
  }
}



