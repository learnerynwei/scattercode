

import org.omg.CORBA.INTERNAL;

public class ld174 {

  int min = Integer.MAX_VALUE;

  public int calculateMinimumHP(int[][] dungeon) {
    dfs(dungeon, 0, 0, 0, 0);
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public int calculateMinimumHPDP(int[][] dungeon) {
    int M = dungeon.length ;
    int N = dungeon[0].length ;
    int dp[] = new int[N];
    int sum[] = new int[N];
    for (int i = 0; i < N; i++) {
      sum[i] = 0;
      dp[i] = 0;
    }
    
    sum[0] = dungeon[0][0];
    dp[0] = dungeon[0][0] >= 0 ? 0 :-dungeon[0][0];
    
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int sum1 = 0, sum2 = 0;
        int dp1 = Integer.MAX_VALUE, dp2  = Integer.MAX_VALUE;
        if(i > 0){
          sum1 = sum[j] < 0 ? dungeon[i][j] : (sum[j] +  dungeon[i][j]);
          dp1  = dp[j] + (sum1 >= 0 ? 0 : -sum1);
        }
        if(j > 0){
          sum2 = sum[j - 1] < 0 ? dungeon[i][j] : (sum[j - 1] +  dungeon[i][j]);
          dp2  = dp[j - 1] + (sum2 >= 0 ? 0 : -sum2);
        }
        if(dp1 == dp2 && dp1 == Integer.MAX_VALUE)
          continue;
        if(dp1 < dp2){
          dp[j] = dp1;
          sum[j] = sum1;
        }else if(dp1 > dp2){
          dp[j] = dp2;
          sum[j] = sum2;
        }else if( sum1 > sum2){
          dp[j] = dp1;
          sum[j] = sum1;
        }else{
          dp[j] = dp2;
          sum[j] = sum2;
        }
      }
    }
    return dp[N-1] + 1;
  }

  public void dfs(int[][] dungeon, int i, int j, int sum, int curMin) {
    int M = dungeon.length - 1;
    int N = dungeon[0].length - 1;
    if (M == i && N == j) {
      if (sum + dungeon[M][N] < 0)
        curMin -= sum + dungeon[M][N];
      if (curMin > 0 && min > curMin + 1)
        min = curMin + 1;
      return;
    }

    if (sum + dungeon[i][j] < 0) {
      curMin -= sum + dungeon[i][j];
      sum = 0;
    } else {
      sum = sum + dungeon[i][j];
    }
    if (curMin >= min)
      return;
    if (j < N) {
      dfs(dungeon, i, j + 1, sum, curMin);
    }
    if (i < M) {
      dfs(dungeon, i + 1, j, sum, curMin);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] a = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
    
    int[][] b = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
    ld174 l174 = new ld174();

    System.out.println(l174.calculateMinimumHPDP(b));
  }

}
