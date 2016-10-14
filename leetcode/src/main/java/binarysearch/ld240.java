package leetcode.binarysearch;

import leetcode.*;

public class ld240 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int i = 0, j = n - 1;
    while(i < m && j >= 0){
      if(matrix[i][j] == target) return true;
      else if(matrix[i][j] > target) j--;
      else i++;
    }
    return false;
  }
  
  public static void main(String[] args) {
    ld240 l209 = new ld240();
    int a[][] = { {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30} };
    
    for(int i=0;i < 30; ++i){
      System.out.println( i + " is : " + l209.searchMatrix(a, i));
    }
  }
}
