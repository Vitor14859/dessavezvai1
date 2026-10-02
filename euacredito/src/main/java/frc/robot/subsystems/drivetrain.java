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
  
<<<<<<< Updated upstream
  private final SparkMax dmotor1 = new SparkMax(Constants.OperatorConstants.dmotor1,MotorType.kBrushed);
  private final SparkMax dmotor2 = new SparkMax(Constants.OperatorConstants.dmotor2,MotorType.kBrushed);
  private final SparkMax emotor1 = new SparkMax(Constants.OperatorConstants.emotor1,MotorType.kBrushed);
  private final SparkMax emotor2 = new SparkMax(Constants.OperatorConstants.emotor2,MotorType.kBrushed);
=======
  public final SparkMax dmotor1 = new SparkMax(Constants.motoresConstants.dmotor1, MotorType.kBrushed);
  public final SparkMax dmotor2 = new SparkMax(Constants.motoresConstants.dmotor2, MotorType.kBrushed);
  public final SparkMax emotor1 = new SparkMax(Constants.motoresConstants.emotor1, MotorType.kBrushed);
  public final SparkMax emotor2 = new SparkMax(Constants.motoresConstants.emotor2, MotorType.kBrushed);
>>>>>>> Stashed changes

    public drivetrain(){
      SparkMaxConfig config22 = new SparkMaxConfig();
      config22.inverted(true);
      config22.follow(dmotor1, true);
      config22.idleMode(IdleMode.kBrake);
      dmotor2.configure(config22,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

      SparkMaxConfig config13 = new SparkMaxConfig();
      config13.follow(emotor1, false);
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
