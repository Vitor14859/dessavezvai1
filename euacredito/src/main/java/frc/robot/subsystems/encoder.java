

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class encoder extends SubsystemBase {
  public static final Encoder loui = new Encoder(Constants.encodercanais.autoA, Constants.encodercanais.autoB  );
  public encoder() {
    
  }

  @Override
  public void periodic() {
  
  }
}
