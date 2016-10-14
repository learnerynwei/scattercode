package leetcode.binarysearch;


public class ld378 {

  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;
    
    int low = matrix[0][0];
    int high = matrix[m-1][n-1];
    while( low < high ){
      int mid = low + (high - low)/2;
      int count = 0;
      for(int i = 0; i < m; ++i)
        for(int j = 0; j < n; ++j)
          if(matrix[i][j] <= mid ){
            count++;
          }else break;
      if(count < k) low = mid + 1;
      else high = mid;
    }
    return low;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] a = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };

    ld378 l174 = new ld378();
    for(int i = 1; i <= 9; ++i)
      System.out.println("No." + i + " is: " + l174.kthSmallest(a, i));
  }

}
