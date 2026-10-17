package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Calculos;
import frc.robot.subsystems.Arm;

public class Armcontrol extends Command{
    public final Calculos calculos = new Calculos();
    public final Arm arm;
    public final Joystick Sim;
    public static double tigreD;


    public Armcontrol(Joystick Sim, Arm arm){
        this.arm = arm;
        this.Sim = Sim;

        addRequirements(arm);
    }

    public void objetos(){
     tigreD = Sim.getRawAxis(3);
    }
    

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    objetos();
    
  }
    
  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

