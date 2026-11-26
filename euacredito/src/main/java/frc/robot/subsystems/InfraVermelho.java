package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InfraVermelho extends SubsystemBase {
 DigitalInput raiva = new DigitalInput(0);

 public static boolean funcionando;
  public InfraVermelho(){

  }

  public boolean VerificarEstado(){
   return raiva.get();
  }

  public void ParadaDeSeguranca() {
    funcionando = !VerificarEstado();
  }

   @Override
  public void periodic() {
    ParadaDeSeguranca();
    SmartDashboard.putBoolean("Estado infravermelho", funcionando);
    SmartDashboard.putBoolean("infravermelho direto", raiva.get());
  }
}

