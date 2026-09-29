package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calculos;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase{
 private final VictorSPX dmotor1 = new VictorSPX(Constants.OperatorConstants.dmotor1);
  private final VictorSPX dmotor2 = new VictorSPX(Constants.OperatorConstants.dmotor2);
  private final VictorSPX emotor1 = new VictorSPX(Constants.OperatorConstants.emotor1);
  private final VictorSPX emotor2 = new VictorSPX(Constants.OperatorConstants.emotor2); 
   
    public drivetrain(){
      dmotor1.setInverted(true);
      dmotor2.setInverted(true);

      dmotor2.follow(dmotor1);
      emotor2.follow(emotor1);

      dmotor1.setNeutralMode(NeutralMode.Brake);
      dmotor2.setNeutralMode(NeutralMode.Brake);
      emotor1.setNeutralMode(NeutralMode.Brake);
      emotor2.setNeutralMode(NeutralMode.Brake);
      
      emotor1.configNeutralDeadband(Constants.OperatorConstants.dz);
      dmotor1.configNeutralDeadband(Constants.OperatorConstants.dz);
    }
 public void drive(double leftvel, double rigthvel) {
    Calculos.vd = rigthvel;
    Calculos.ve = leftvel;
    dmotor1.set(ControlMode.PercentOutput, Calculos.vd);
    emotor1.set(ControlMode.PercentOutput, Calculos.ve);
    }

}