
public class ld171 {

  public static int titleToNumber(String s) {
    int res = 0;
    int i = 0;
    while( i < s.length() ){
      res *= 26;
      res += (s.charAt(i++) - 'A' + 1);
    }
    return res ;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for( int i = 1; i < 1024; i++){
      String str = ld168.convertToTitle(i);
//      System.out.println("Original: " + i);
//      System.out.println("Title: " + str);
      System.out.println(titleToNumber(str) == i );
    }
  }

}
