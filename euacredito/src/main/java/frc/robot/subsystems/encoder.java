

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class encoder extends SubsystemBase {
  public static final Encoder auto = new Encoder(Constants.encodercanais.autoA, Constants.encodercanais.autoB, false,  Encoder.EncodingType.k2X);
  public encoder() {
    auto.setDistancePerPulse(4 / 256);
  }

  public double takeDistance(){
    return auto.getDistance();
  }

  public void reset(){
    auto.reset();
  }
}
