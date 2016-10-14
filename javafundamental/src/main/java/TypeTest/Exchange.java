package TypeTest;

public class Exchange {

  public static void main(String[] args) {
    int x = 20, y = 35;

    System.out.println("Before:");
    System.out.println("x: " + x);
    System.out.println("y: " + y);

    x = x + y;
    y = x - y;
    x = x - y;

    System.out.println("After 1:");
    System.out.println("x: " + x);
    System.out.println("y: " + y);

    x ^= y;
    y ^= x;
    x ^= y;

    System.out.println("After 2:");
    System.out.println("x: " + x);
    System.out.println("y: " + y);
  }

}
