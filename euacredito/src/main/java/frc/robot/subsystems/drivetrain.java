package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase{ 
  
  public final SparkMax dmotor1 = new SparkMax(Constants.MotoresConstants.dmotor1, MotorType.kBrushed);
  public final SparkMax dmotor2 = new SparkMax(Constants.MotoresConstants.dmotor2, MotorType.kBrushed);
  public final SparkMax emotor1 = new SparkMax(Constants.MotoresConstants.emotor1, MotorType.kBrushed);
  public final SparkMax emotor2 = new SparkMax(Constants.MotoresConstants.emotor2, MotorType.kBrushed);
    
    public drivetrain(){
      SparkMaxConfig d2 = new SparkMaxConfig();
      d2.idleMode(IdleMode.kBrake);
      dmotor2.configure(d2,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      dmotor1.configure(d2,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

      SparkMaxConfig e2 = new SparkMaxConfig();
      e2.inverted(true);
      e2.idleMode(IdleMode.kBrake);
      emotor2.configure(e2,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      emotor1.configure(e2,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
       public void drive(double leftvel, double rigthvel) {
      dmotor1.set(rigthvel); dmotor2.set(rigthvel);
      emotor1.set(leftvel);  emotor2.set(leftvel);
    }
}