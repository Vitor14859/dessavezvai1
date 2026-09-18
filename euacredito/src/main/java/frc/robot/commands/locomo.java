package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Calculos;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
public class locomo extends Command {
 boolean A, B, C, D;
 double Ex, Ey ,Dx ,Dy, tigreD, tigreE, vel, vd, ve;
 int angulo;
    private final Calculos calculos = new Calculos();
    private final Joystick sim;
    @SuppressWarnings ("unused")
    private final drivetrain drive;
  public locomo(Joystick sim ,drivetrain drive) { 
   this.sim = sim;
   this.drive = drive;

   addRequirements(drive);
  }

  public void objetos(){
    angulo = sim.getPOV();
    A = sim.getRawButton(1);
    B = sim.getRawButton(2);
    C = sim.getRawButton(3);
    D = sim.getRawButton(4);

    
    Ex = sim.getRawAxis(0); 
    Ey = -sim.getRawAxis(1);
    Dx = sim.getRawAxis(4); 
    Dy = -sim.getRawAxis(5);

    tigreD = sim.getRawAxis(3);
    tigreE = sim.getRawAxis(2);
    tigreE *= -1;
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    dashboard();
    botoes();
    calculos.caulculoesq(Ey, Ex);
    calculos.caulculodir(Dx, Dy);

    if(Calculos.hipotenusa> Constants.OperatorConstants.dz){
     calculos.anlesq(Ex, Ey, vd, ve, vel);
    }
    else if (Calculos.hipotenusa2 >  Constants.OperatorConstants.dz){
      calculos.anldir(Dx, Dy, vd, ve, vel);
    }
    else if(tigreD >  Constants.OperatorConstants.dz || tigreE < - Constants.OperatorConstants.dz){
      calculos.Triggers(tigreD, vd, ve, tigreE, vel);
    }
    else if (sim.getPOV() != -1) {
        calculos.pov(ve, angulo, vd, vel);
    }
    else{
      vd = 0; ve = 0;
    }

  }
  
  public void botoes(){
    if (A) {
      vel = 0.25;
    } else if (B) { 
      vel = 0.5;
    } else if (C) { 
      vel = 0.75;
    } else if (D) { 
      vel = 1.0;
    }
  }
  
  public void dashboard(){

      SmartDashboard.putBoolean("Button A", A);
      SmartDashboard.putBoolean("Button B", B);
      SmartDashboard.putBoolean("Button C", C);
      SmartDashboard.putBoolean("Button D", D);
      SmartDashboard.putNumber("Button Speed", vel);
      SmartDashboard.putNumber("angulo do pov", angulo);
      SmartDashboard.putNumber("velocidade esquerda", ve);
      SmartDashboard.putNumber("velocidade direita", vd);
      SmartDashboard.putNumber("tigrinho direito", tigreD);
      SmartDashboard.putNumber("tigrinho esquerdo", tigreE);
  }
  
  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

