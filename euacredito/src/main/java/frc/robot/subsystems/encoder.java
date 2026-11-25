

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class encoder extends SubsystemBase {
  public static final Encoder auto = new Encoder(Constants.encoder.autoA, Constants.encoder.autoB, false,  Encoder.EncodingType.k4X);
  public encoder() {
    auto.setDistancePerPulse(360.0 / 8192.0);
  }

  public double takeDistance(){
    return auto.getDistance();
  }

  public void reset(){
    auto.reset();
  }
}
