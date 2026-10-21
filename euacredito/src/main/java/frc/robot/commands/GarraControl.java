package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Calculos;
import frc.robot.subsystems.Garra;

public class GarraControl extends Command {
  public static boolean L2, R2;
  public final Calculos calculos = new Calculos();
  public final Garra garra;
  public final Joystick Sim;

  public GarraControl(Garra garra, Joystick sim) {
    this.garra = garra;
    this.Sim = sim;

    addRequirements(garra);
  }

  public void objetos(){
    L2 = Sim.getRawButton(5);
    R2 = Sim.getRawButton(6);

  }
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    objetos();
    calculos.garraON();
    garra.garravel(Calculos.garravel);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
