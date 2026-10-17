package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    public final SparkMax armmotor = new SparkMax(Constants.MotoresConstants.motorangulo ,MotorType.kBrushless );

    public Arm (){
        SparkMaxConfig arm = new SparkMaxConfig();
        arm.idleMode(IdleMode.kBrake);
        armmotor.configure(arm ,ResetMode.kResetSafeParameters ,PersistMode.kPersistParameters);
    }

    public void setvel(double vel){
    armmotor.set(vel);
    }
}
