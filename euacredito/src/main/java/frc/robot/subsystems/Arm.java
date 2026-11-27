package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.ResetMode;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    public final SparkMax armmotor = new SparkMax(Constants.MotoresConstants.motorangulo ,MotorType.kBrushless);
    public final RelativeEncoder armEncoder;
    public final PIDController PID = new PIDController(
        Constants.Arm.KpArmPID, 
      Constants.Arm.KiArmPID, 
    Constants.Arm.KdArmPID
    );
    public Arm (){
        PID.setTolerance(Constants.Arm.PIDtolerance);

        SparkMaxConfig arm = new SparkMaxConfig();
        arm.idleMode(IdleMode.kBrake);
        armmotor.configure(arm ,ResetMode.kResetSafeParameters ,PersistMode.kPersistParameters);
        armEncoder = armmotor.getEncoder();

    }

    public void setvelarm(double vel){
    armmotor.set(vel);
    }

    public double pegarposicao(){
        return armEncoder.getPosition();
    }
      @Override
  public void periodic() {
    armmotor.set(PID.calculate(armEncoder.getPosition(), 0));
    SmartDashboard.putNumber("encoder posição: ", pegarposicao());
    SmartDashboard.putNumber("taxa de erro pid: ", PID.getError());
    
  }

}
