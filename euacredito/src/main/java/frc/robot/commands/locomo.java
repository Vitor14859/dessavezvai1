package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Calculos;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class locomo extends Command {
 public static boolean A, B, C, D;
 public static double eixoEx, eixoEy,eixoDx , eixoDy, tigreD, tigreE;
    public final Calculos calculos = new Calculos();
    public final Joystick Sim;
    public final drivetrain Drive;
    
    
    
  public locomo(Joystick sim ,drivetrain drive) { 
   this.Sim = sim;
   this.Drive = drive;

   addRequirements(drive);
  }

  public void objetos(){
    Calculos.angulo = Sim.getPOV();
    A = Sim.getRawButton(1);
    B = Sim.getRawButton(2);
    C = Sim.getRawButton(3);
    D = Sim.getRawButton(4);

    
    eixoEx = Sim.getRawAxis(0); 
    eixoEy = -Sim.getRawAxis(1);
    eixoDx = Sim.getRawAxis(4); 
    eixoDy = -Sim.getRawAxis(5);
    
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
      calculos.anldir();
    }
    else if (Sim.getPOV() != -1) {
        calculos.pov();
    }
    else{
      Calculos.vd = 0; Calculos.ve = 0;
    }
    
    calculos.botoes();
    calculos.caulculoesq();
    calculos.caulculodir();
    dashboard();
    Drive.drive(Calculos.ve, Calculos.vd);
      
    
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
      SmartDashboard.putNumber( "timer", Auto.milena.get());
      SmartDashboard.putNumber("arm vel", Calculos.armvel);
      SmartDashboard.putNumber("garra vel", Calculos.garravel);
    }
   
  
  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

