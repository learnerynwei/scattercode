package list;

import java.util.ArrayList;
import java.util.List;

public class Reference {

  static class A{
    boolean isOk;
    public A(boolean ok){
      this.isOk = ok;
    }
  }
  
  public static void testReference(){
    List<A> la = new ArrayList<>(10);
    A a = new A(false);
    System.out.println("A is OK, is right ?  " + a.isOk);
    la.add(a);
    a.isOk = true;
    System.out.println("A is OK, is right ?  " + a.isOk);
    A b = la.get(0);
    System.out.println("list size is : " + la.size());
   
    System.out.println("A is OK, is right ?  " + b.isOk);
  }  
  
  public static void main(String[] args) {
    testReference();
  }
}
