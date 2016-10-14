

public class ld168 {

  private final static char dir[] = {
     'A', 'B', 'C', 'D', 'E', 'F',
     'G', 'H', 'I', 'J', 'K', 'L', 'M',
     'N', 'O', 'P', 'Q', 'R', 'S', 'T',
     'U', 'V', 'W', 'X', 'Y', 'Z'
  };
  // 注意26倍数情况
  //return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
  public static String convertToTitle(int n) {
    if( n <= 0) return "";
    StringBuilder builder = new StringBuilder();
    while( n > 0){
      builder.append(dir[--n%26]);
      n = n / 26 ;
    }
    return builder.reverse().toString();
  }
  
  public static void main(String[] args) {
    for( int i = 1; i < 1024; i++){
      System.out.print(convertToTitle(i) + "\t");
      if( i % 26 == 0){
        System.out.println();
      }
    }
  }

}
