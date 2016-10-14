package string;

public class StringConst {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str1 = "1234";
    String str2 = "1234";
    String str3 = new String("1234");
    String str4 = new String("1234");
    System.out.println("Str1 ==  str2: " + (str1 == str2));
    System.out.println("Str1 ==  str3: " + (str1 == str3));
    System.out.println("Str3 ==  str4: " + (str3 == str4));
    System.out.println("Str3 equals to str4: " + str3.equals(str4));
    
    //5种整形的包装类Byte,Short,Integer,Long,Character的对象，  
    
    //在值小于127时可以使用常量池  
   
    Integer i1=127;  
   
    Integer i2=127;  
   
    System.out.println(i1==i2);//输出true  
   
    //值大于127时，不会从常量池中取对象  
   
    Integer i3=128;  
   
    Integer i4=128;  
   
    System.out.println(i3==i4);//输出false  
   
    //Boolean类也实现了常量池技术  
   
    Boolean bool1=true;  
   
    Boolean bool2=true;  
   
    System.out.println(bool1==bool2);//输出true  
   
    //浮点类型的包装类没有实现常量池技术  
   
    Double d1=1.0;  
   
    Double d2=1.0;  
   
    System.out.println(d1==d2);//输出false  
  }

}
