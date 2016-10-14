package hiho;

import java.util.Scanner;

public class hiho70 {

  private static int count = 0;

  private static int target = 0;

  public static void dfs(int last, int cur, long multi){
    if( last == 0 ){
      if( multi % target == 0)
        count++;
      return ;
    }
    if( last < cur)
      return ;
    for(int next = cur; next <= last; next++){
      dfs(last - next, next + 1, multi* next);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N,M;
    N = sc.nextInt();
    M = sc.nextInt();
    hiho70.setCount(0);
    hiho70.setTarget(M);
    hiho70.dfs(N, 1, 1);
    System.out.println(hiho70.getCount());
  }

  public static int getCount() {
    return count;
  }

  public static void setCount(int count) {
    hiho70.count = count;
  }

  public static int getTarget() {
    return target;
  }

  public static void setTarget(int target) {
    hiho70.target = target;
  }

}
