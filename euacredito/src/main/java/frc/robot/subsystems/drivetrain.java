package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calculos;
import frc.robot.Constants;


public class drivetrain extends SubsystemBase{
  
  private final SparkMax dmotor1 = new SparkMax(Constants.OperatorConstants.dmotor1, MotorType.kBrushed);
  private final SparkMax dmotor2 = new SparkMax(Constants.OperatorConstants.dmotor2, MotorType.kBrushed);
  private final SparkMax emotor1 = new SparkMax(Constants.OperatorConstants.emotor1,MotorType.kBrushed);
  private final SparkMax emotor2 = new SparkMax(Constants.OperatorConstants.emotor2,MotorType.kBrushed); 
   
   
    public void drive(double leftvel, double rigthvel) {
    Calculos.vd = rigthvel;
    Calculos.ve = leftvel;
    dmotor1.set(Calculos.vd);
    emotor1.set(Calculos.ve);
    }
    public drivetrain(){
      dmotor1.setInverted(true);
      dmotor2.setInverted(true);

      dmotor2.
      emotor2.follow(emotor1);

      dmotor1.setNeutralMode(NeutralMode.Brake);
      dmotor2.setNeutralMode(NeutralMode.Brake);
      emotor1.setNeutralMode(NeutralMode.Brake);
      emotor2.setNeutralMode(NeutralMode.Brake);
      
      emotor1.configNeutralDeadband(Constants.OperatorConstants.dz);
      dmotor1.configNeutralDeadband(Constants.OperatorConstants.dz);
    }
     public void dirigirparafrente(){
      drive(1, 1);
     }
     

}
