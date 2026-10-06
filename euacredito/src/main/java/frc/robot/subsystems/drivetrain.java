package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calculos;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase{
  
  public final SparkMax dmotor1 = new SparkMax(Constants.MotoresConstants.dmotor1, MotorType.kBrushed);
  public final SparkMax dmotor2 = new SparkMax(Constants.MotoresConstants.dmotor2, MotorType.kBrushed);
  public final SparkMax emotor1 = new SparkMax(Constants.MotoresConstants.emotor1, MotorType.kBrushed);
  public final SparkMax emotor2 = new SparkMax(Constants.MotoresConstants.emotor2, MotorType.kBrushed);

    public drivetrain(){
      SparkMaxConfig config22 = new SparkMaxConfig();
      config22.follow(dmotor1, true);
      config22.idleMode(IdleMode.kBrake);
      dmotor2.configure(config22,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

      SparkMaxConfig config13 = new SparkMaxConfig();
      config13.follow(emotor1, true);
      config13.idleMode(IdleMode.kBrake);
      emotor2.configure(config13,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);  
    }

     
    public void drive(double leftvel, double rigthvel) {
    Calculos.vd = rigthvel;
    Calculos.ve = leftvel;
    dmotor1.set(Calculos.vd);
    emotor1.set(Calculos.ve);
    }
}
