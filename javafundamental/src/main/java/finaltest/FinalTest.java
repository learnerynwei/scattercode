package finaltest;

public class FinalTest {
  private static int incrFinal(final int i){
//    return i++;
    return i+1;
  }
  
  public static void testVar(){
    final int a = 5;
    int b = incrFinal(a);
  }
  

  static class A{
    int i;
    String str;
    public A(int i, String str){
      this.i = i;
      this.str = str;
    }
  }

  private static A testChange(final A a){
//    a = new A(0, "Changed");
    a.i = 5;
    a.str = "Changed!";
    return a;
  }
  public static void testVar2(){
    final A a = new A(0, "Original!");
    System.out.println("Original: i : " + a.i + " , str: " + a.str);
    A b = testChange(a);
    System.out.println("Changed: i : " + b.i + " , str: " + b.str);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    testVar2();
  }
}
