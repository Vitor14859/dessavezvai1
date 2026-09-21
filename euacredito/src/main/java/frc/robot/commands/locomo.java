package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Calculos;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class locomo extends Command {
 boolean A, B, C, D;
 public static double eixoEx, eixoEy,eixoDx , eixoDy, tigreD, tigreE;
    public final Calculos calculos = new Calculos();
    public final Joystick sim;
    public final drivetrain drive;
    
    
  public locomo(Joystick sim ,drivetrain drive) { 
   this.sim = sim;
   this.drive = drive;

   addRequirements(drive);
  }

  public void objetos(){
    Calculos.angulo = sim.getPOV();
    A = sim.getRawButton(1);
    B = sim.getRawButton(2);
    C = sim.getRawButton(3);
    D = sim.getRawButton(4);

    
    eixoEx = sim.getRawAxis(0); 
    eixoEy = -sim.getRawAxis(1);
    eixoDx = sim.getRawAxis(4); 
    eixoDy = -sim.getRawAxis(5);

    tigreD = sim.getRawAxis(3);
    tigreE = sim.getRawAxis(2);
    tigreE *= -1;

    
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    objetos();
    if(Calculos.hipotenusa> Constants.OperatorConstants.dz){
     calculos.anlesq();
    }
    else if (Calculos.hipotenusa2 >  Constants.OperatorConstants.dz){
      calculos.anldir(

      );
    }
    else if(tigreD >  Constants.OperatorConstants.dz || tigreE < - Constants.OperatorConstants.dz){
      calculos.Triggers();
    }
    else if (sim.getPOV() != -1) {
        calculos.pov();
    }
    else{
      Calculos.vd = 0; Calculos.ve = 0;
    }
    
    botoes();
    calculos.caulculoesq();
    calculos.caulculodir();
    dashboard();
  }

  public void botoes(){
    if (A) {
      Calculos.vel = 0.25;
    } else if (B) { 
      Calculos.vel = 0.5;
    } else if (C) { 
      Calculos.vel = 0.75;
    } else if (D) { 
      Calculos.vel = 1.0;
    }
  }
  
  public void dashboard(){

      SmartDashboard.putBoolean("Button A", A);
      SmartDashboard.putBoolean("Button B", B);
      SmartDashboard.putBoolean("Button C", C);
      SmartDashboard.putBoolean("Button D", D);
      SmartDashboard.putNumber("Button Speed", Calculos.vel);
      SmartDashboard.putNumber("angulo do pov", Calculos.angulo);
      SmartDashboard.putNumber("velocidade esquerda", Calculos.ve);
      SmartDashboard.putNumber("velocidade direita", Calculos.vd);
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

