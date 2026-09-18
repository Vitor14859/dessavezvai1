package frc.robot;



import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.drivetrain;

public class Calculos extends drivetrain{

    
    public static double hipotenusa, hipotenusa2;
    double sen, sen1;
    private final double dz = OperatorConstants.dz;


     public void pov(double ve, int angulo, double vd , double vel){
    switch (angulo) {
      case 0:  ve = 1; vd = 1;  break;
      case 45: ve = 1; vd = 0.5; break;
      case 90: ve = 1; vd = 0.0; break;
      case 135: ve = -1; vd = 0.5; break;
      case 180: ve = -1; vd = 1; break;
      case 225: ve = -0.5; vd = -1; break;
      case 270: ve = 0; vd = 1; break;
      case 315: ve = 0.5; vd = 1; break;
      default: ve = 0; vd = 0;
    }
    vd *= vel;
    ve *= vel;
  }
  
  public void Triggers(double tigreD, double vd, double ve, double tigreE, double vel){
    if (tigreD > dz){
      vd = tigreD;
      ve = tigreD;
    }
    else if (tigreE < -dz){
      ve = tigreE;
      vd = tigreE;
    }
    else{
      vd = 0;
      ve = 0;
    }
    vd *= vel;
    ve *= vel;
  }
    public void caulculoesq(double eixoEy, double eixoEx) {
      double cal = (eixoEx * eixoEx) + (eixoEy * eixoEy);
      if (cal > 1){
        cal = 1;
      }
      sen = eixoEx / hipotenusa;
     hipotenusa = Math.sqrt(cal);
            
    }
    public void caulculodir(double eixoDx, double eixoDy){ 
    double cal3 = (eixoDx * eixoDx)+ (eixoDy * eixoDy);
    if(cal3 > 1){
      cal3 = 1;
    }
    sen1 = eixoDx / hipotenusa2;
    hipotenusa2 = Math.sqrt(cal3);
    }

    public void anlesq(double eixoEx, double eixoEy, double vd, double ve, double vel) {
      if(eixoEx > dz && eixoEy > dz){
        
        vd = hipotenusa -sen; ve = hipotenusa ;
      }
      else if(eixoEx < -dz && eixoEy > dz) {
        vd = hipotenusa; ve = hipotenusa + sen ;
      }
      else if(eixoEx < -dz && eixoEy < -dz){
        vd =  hipotenusa ; ve =  hipotenusa - sen ;
      } 
      else if(eixoEx > dz && eixoEy < -dz){
        vd =  hipotenusa +sen ; ve =  hipotenusa;
      }

      
      else if(eixoEx < dz && eixoEy > dz){
        vd = hipotenusa ; ve = hipotenusa ;
      }
      else if(eixoEx > dz && eixoEy < dz){
        vd = 0; ve = hipotenusa ;
      }
      else if(eixoEx < dz && eixoEy < -dz){
        vd =  hipotenusa; ve =  hipotenusa ;
      }
      else if(eixoEx < -dz && eixoEy < dz){
        vd = hipotenusa  ; ve = 0;
      }
      
      else{
        vd=0;ve=0;
      }
      vd *= vel;
      ve *= vel;  
    }
    public void anldir(double eixoDx, double eixoDy, double vd, double ve, double vel) {
     if(eixoDx > dz && eixoDy > dz){
        
        vd = hipotenusa2 -sen1; ve = hipotenusa2 ;
      }
      else if(eixoDx < -dz && eixoDy > dz) {
        vd = hipotenusa2; ve = hipotenusa2 + sen1 ;
      }
      else if(eixoDx < -dz && eixoDy < -dz){
        vd = -hipotenusa2 ; ve = -hipotenusa2 - sen1 ;
      } 
      else if(eixoDx > dz && eixoDy < -dz){
        vd = -hipotenusa2 +sen1 ; ve = -hipotenusa2;
      }

      
      else if(eixoDx < dz && eixoDy > dz){
        vd = hipotenusa2 ; ve = hipotenusa2 ;
      }
      else if(eixoDx > dz && eixoDy < dz){
        vd = 0; ve = hipotenusa2 ;
      }
      else if(eixoDx < dz && eixoDy < -dz){
        vd = -hipotenusa2; ve = -hipotenusa2 ;
      }
      else if(eixoDx < -dz && eixoDy < dz){
        vd = hipotenusa2  ; ve = 0;
      }
      
      else{
        vd=0;ve=0;
      }
      vd *= vel;
      ve *= vel;  
    }
    
}
