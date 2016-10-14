package TypeTest;

public class TestLong {

  public static void testLong(){
    long a = 9223372036854775806L;
    long res = 1;
    for(int  i = 1; i < 100; ++i)     
      System.out.println(i + "  "+ (res *= i ));
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    long b = 1;
//    switch(b){
//    
//    }
    TestLong.testLong();
  }

}
