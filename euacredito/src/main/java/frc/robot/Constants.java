package frc.robot;

public final class Constants {
  public static class OperatorConstants {  
    public static final double dz = 0.04;
    public static final int sim = 0;
    
  }
  public static class MotoresConstants {
    public static final int dmotor1 = 4;
    public static final int dmotor2 = 3;
    public static final int emotor1 = 2;
    public static final int emotor2 = 1;
    public static final int motorangulo = 15;
    public static final int garramotor = 14;
  }

  public static class encoder{
    public static final int autoA = 1;
    public static final int autoB = 2;
    public static final double diametroRoda = 0.15;
    public static final double pulsoporvolta = 8192.0;
  }

  public static class AutoConstants{
    public static final double distanciaAlvo =-1.0;
    public static final double velocidade = 0.5;
}

  public static class DigitalInput{
    public static final int infravermelho = 0;
  }

  public static class Arm{
    public static final double PIDtolerance = 1;
    public static final double KpArmPID = 0.0001;
    public static final double KiArmPID = 0;
    public static final double KdArmPID = 0;
    public static final double setpoint = 0;
    public static final boolean manual = false;
  }

}
