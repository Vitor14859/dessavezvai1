package frc.robot;

import frc.robot.commands.Armcontrol;
import frc.robot.commands.GarraControl;
import frc.robot.commands.locomo;

public class Calculos {

    
    public static double hipotenusa, hipotenusa2;
    double sen, sen1;
    public static double ve, vd, armvel, garravel;
    public static double vel = 0;
    public static int angulo;
    

      public void botoes(){
    if (locomo.A) {
      Calculos.vel = 0.25;
    } else if (locomo.B) { 
      Calculos.vel = 0.5;
    } else if (locomo.C) { 
      Calculos.vel = 0.75;
    } else if (locomo.D) { 
      Calculos.vel = 1.0;
    }
  }

     public void pov(){
    switch (angulo) {
      case 0:  ve = 1; vd = 1;  break;
      case 45: ve = 1; vd = 0.5; break;
      case 90: ve = 1; vd = 0.0; break;
      case 135: ve = -1; vd = 0.5; break;
      case 180: ve = -1; vd = -1; break;
      case 225: ve = -0.5; vd = -1; break;
      case 270: ve = 0; vd = 1; break;
      case 315: ve = 0.5; vd = 1; break;
      default: ve = 0; vd = 0;
    }
    vd *= vel;
    ve *= vel;
  }
  
    public void caulculoesq() {
      double cal = (locomo.eixoEx * locomo.eixoEx) + (locomo.eixoEy * locomo.eixoEy);
      if (cal > 1){
        cal = 1;
      }
      sen = locomo.eixoEx / hipotenusa;
     hipotenusa = Math.sqrt(cal);
            
    }
    public void caulculodir(){ 
    double cal3 = (locomo.eixoDx * locomo.eixoDx)+ (locomo.eixoDy * locomo.eixoDy);
    if(cal3 > 1){
      cal3 = 1;
    }
    sen1 = locomo.eixoDx / hipotenusa2;
    hipotenusa2 = Math.sqrt(cal3);
    }

    public void anlesq() {
      if(locomo.eixoEx > Constants.OperatorConstants.dz && locomo.eixoEy > Constants.OperatorConstants.dz){      
        vd = hipotenusa -sen; ve = hipotenusa ;
      }
      else if(locomo.eixoEx < -Constants.OperatorConstants.dz && locomo.eixoEy > Constants.OperatorConstants.dz) {
        vd = hipotenusa; ve = hipotenusa + sen ;
      }
      else if(locomo.eixoEx < -Constants.OperatorConstants.dz && locomo.eixoEy < -Constants.OperatorConstants.dz){
        vd =  -hipotenusa ; ve =  -hipotenusa - sen ;
      } 
      else if(locomo.eixoEx > Constants.OperatorConstants.dz && locomo.eixoEy < -Constants.OperatorConstants.dz){
        vd =  -hipotenusa + sen ; ve =  -hipotenusa;
      }

      
      else if(locomo.eixoEx < Constants.OperatorConstants.dz && locomo.eixoEy > Constants.OperatorConstants.dz){
        vd = hipotenusa ; ve = hipotenusa ;
      }
      else if(locomo.eixoEx > Constants.OperatorConstants.dz && locomo.eixoEy < Constants.OperatorConstants.dz){
        vd = 0; ve = hipotenusa ;
      }
      else if(locomo.eixoEx < Constants.OperatorConstants.dz && locomo.eixoEy < -Constants.OperatorConstants.dz){
        vd =  -hipotenusa; ve =  -hipotenusa ;
      }
      else if(locomo.eixoEx < -Constants.OperatorConstants.dz && locomo.eixoEy < Constants.OperatorConstants.dz){
        vd = hipotenusa  ; ve = 0;
      }
      
      else{
        vd=0;ve=0;
      }
      vd *= vel;
      ve *= vel;  
    }
    public void anldir() {
     if(locomo.eixoDx > Constants.OperatorConstants.dz && locomo.eixoDy > Constants.OperatorConstants.dz){
        
        vd = hipotenusa2 -sen1; ve = hipotenusa2 ;
      }
      else if(locomo.eixoDx < -Constants.OperatorConstants.dz && locomo.eixoDy > Constants.OperatorConstants.dz) {
        vd = hipotenusa2; ve = hipotenusa2 + sen1 ;
      }
      else if(locomo.eixoDx < -Constants.OperatorConstants.dz && locomo.eixoDy < -Constants.OperatorConstants.dz){
        vd = -hipotenusa2 ; ve = -hipotenusa2 - sen1 ;
      } 
      else if(locomo.eixoDx > Constants.OperatorConstants.dz && locomo.eixoDy < -Constants.OperatorConstants.dz){
        vd = -hipotenusa2 +sen1 ; ve = -hipotenusa2;
      }

      
      else if(locomo.eixoDx < Constants.OperatorConstants.dz && locomo.eixoDy > Constants.OperatorConstants.dz){
        vd = 1 ; ve = 1 ;
      }
      else if(locomo.eixoDx > Constants.OperatorConstants.dz && locomo.eixoDy < Constants.OperatorConstants.dz){
        vd = 0; ve = 1 ;
      }
      else if(locomo.eixoDx < Constants.OperatorConstants.dz && locomo.eixoDy < -Constants.OperatorConstants.dz){
        vd = -1; ve = -1 ;
      }
      else if(locomo.eixoDx < -Constants.OperatorConstants.dz && locomo.eixoDy < Constants.OperatorConstants.dz){
        vd = 1  ; ve = 0;
      }
      
      else{
        vd=0;ve=0;
      }
      vd *= vel;
      ve *= vel;  
    }

   public void ArmAngle(){
     if (Armcontrol.tigreD > Constants.OperatorConstants.dz){
      armvel = Armcontrol.tigreD;
    }
     else if(Armcontrol.tigreE < -Constants.OperatorConstants.dz){
      armvel = Armcontrol.tigreE;
    }
    else{
      armvel = 0;
      armvel = 0;
    }

    armvel *= 0.2;
   }

   public void garraON(){
    if (GarraControl.L2){
      garravel = -1;
    }
    else if (GarraControl.R2){
      garravel = 1;
    }
    else {
      garravel = 0;
    }

   }
    
}
