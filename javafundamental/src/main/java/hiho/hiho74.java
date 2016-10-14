package hiho;

import java.util.Scanner;

public class hiho74 {

  public static int getSalaries(double tax){
    double res = 3500;
    if( tax >= 22495 ){
      res += 80000;
      res += (tax - 22495) * 20 / 9;
    }else if( tax >= 13745 ){
      res += 55000;
      res += (tax - 13745) * 20 / 7;
    }else if( tax >= 7745){
      res += 35000;
      res += (tax - 7745) * 10 / 3;
    }else if( tax >= 1245){
      res += 9000;
      res += (tax - 1245) * 4;
    }else if( tax >= 345){
      res += 4500;
      res += (tax - 345) * 5;
    }else if( tax >= 45){
      res += 1500;
      res += ( tax - 45) * 10;
    }else{
      res += tax * 100 / 3;
    }
    return (int)res;
  }
  
  
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    double tax;
    tax = sc.nextDouble();
    System.out.println(hiho74.getSalaries( tax ));
  }
}
