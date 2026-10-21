package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {
    public final SparkMax garramotor = new SparkMax(Constants.MotoresConstants.garramotor, MotorType.kBrushless);

    public Garra(){
     SparkMaxConfig garra = new SparkMaxConfig();
     garra.idleMode(IdleMode.kBrake);
     garramotor.configure(garra, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void garravel(double vel){
        garramotor.set(vel);
    }
}
