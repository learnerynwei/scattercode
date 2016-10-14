package leetcode.binarysearch;

import java.util.Arrays;

import leetcode.*;

public class ld274 {

  public int hIndex(int[] citations) {
    if(citations == null || citations.length <= 0) return 0;
    Arrays.sort(citations);
    int count = 0;
    for(int i=citations.length - 1; i >= 0; i--){
      if(count < citations[i]){
        count++;
      }else if(count == citations[i])
        return count;
      else break;
    }
    return count;
  }
  
  public static void main(String[] args) {
    ld274 l209 = new ld274();
    int a[][] = { {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30} };
    
    int b[] = {3, 0, 6, 1, 5};
    System.out.println(l209.hIndex(b));
    int c[] = {0};
    System.out.println(l209.hIndex(c));
    int d[] = {0, 3, 1, 3, 3, 4};
    System.out.println(l209.hIndex(d));
//    for(int i=0;i < 30; ++i){
//      System.out.println( i + " is : " );
//    }
  }
}
