import java.math.*;

public class ld38 {

  public String countAndSay(int n) {
    if (n <= 0)
      return "";
    String str = "1";
    for (int i = 1; i < n; i++) {
      str = next(str);
    }
    return str;
  }

  private String next(String str) {
    int count = 1;
    char c = str.charAt(0);
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < str.length(); ++i) {
      char tempC = str.charAt(i);
      if (c == tempC) {
        count++;
      } else {
        sb.append(count);
        sb.append(c);
        count = 1;
        c = tempC;
      }
    }
    sb.append(count);
    sb.append(c);
    return sb.toString();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ld38 ld = new ld38();
    for (int i = 0; i <= 10; i++) {
      System.out.println(ld.countAndSay(i));
    }
  }
}
