package hiho;

import java.util.Scanner;

import javax.management.MXBean;
import javax.swing.text.StyleConstants;

public class hiho1032 {

  private static final int N = 10000000;
  private static boolean dp[][] = new boolean[2][N];

  public static int getMaxPlalindrome(String str){
    int len = str.length();
    int maxLen = 1;

    if( len == 1){
      return 1;
    }else if( len == 2){
      if( str.charAt(0) == str.charAt(1) )
        return 2;
      else
        return 1;
    }

    int cur = 0;
    int next = 1;
    for(int i = 0; i < len; ++i){
      dp[cur][i] = true;
    }

    for(int i = 0; i < len - 1; ++i){
      if( str.charAt(i) == str.charAt(i+1) ){
        dp[next][i] = true;
        maxLen = 2;
      }else
        dp[next][i] = false;
    }

    for(int i = 3; i <= len; ++i){
      for(int j = 0; j <= len - i; ++j ){
        if( dp[cur][j+1] &&
            ( str.charAt(j) == str.charAt(j+i-1) ) ){
          dp[cur][j] = true;
          maxLen = i;
        }else{
          dp[cur][j] = false;
        }
      }
      next ^= cur;
      cur ^= next;
      next ^= cur;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String string = sc.nextLine();
      System.out.println(hiho1032.getMaxPlalindrome(string));
    }
  }
}
