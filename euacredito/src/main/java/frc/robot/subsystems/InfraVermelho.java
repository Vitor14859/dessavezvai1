package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calculos;
import frc.robot.Constants;

public class InfraVermelho extends SubsystemBase {
 DigitalInput raiva = new DigitalInput(Constants.DigitalInput.infravermelho);
 boolean funcionando;
  public InfraVermelho(){

  }

  public boolean VerificarEstado(){
   return raiva.get();
  }


  public void ParadaDeSeguranca(){
    if(VerificarEstado() == false){
      funcionando = true;
      Calculos.vd = 0; Calculos.ve = 0;
    }
    else{
      funcionando = false;
    }
  }
}

