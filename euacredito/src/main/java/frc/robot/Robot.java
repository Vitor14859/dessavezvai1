
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

 
;
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
 

  public final RobotContainer m_robotContainer;

    public Robot() {
    m_robotContainer = new RobotContainer();
   
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
   RobotContainer.milena.reset();
  }

  @Override
  public void autonomousPeriodic() {
    if(RobotContainer.milena.get() < 2){
      RobotContainer.milena.start();
      Calculos.vd = 1; Calculos.ve = 1;
      
    }
      else{
        Calculos.vd = 0; Calculos.ve = 0;
      }
    }
  

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
