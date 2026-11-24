package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calculos;
import frc.robot.Constants;

public class InfraVermelho extends SubsystemBase {
 drivetrain drive;
 DigitalInput raiva = new DigitalInput(0);
 
  public InfraVermelho(drivetrain drive){
    this.drive = drive;
  }

  public boolean VerificarEstado(){
   return raiva.get();
  }

  public void ParadaDeSeguranca(){
  if(Calculos.vd > Constants.OperatorConstants.dz || Calculos.ve > Constants.OperatorConstants.dz){
    if(VerificarEstado() == false){
      drive.drive(0, 0);
    }
    else{
      
    }
  }
  else{
    
  }
  }

}
