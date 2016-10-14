package leetcode.binarysearch;

import java.util.Arrays;

import leetcode.*;

public class ld275 {

  public int hIndex(int[] citations) {
    if(citations == null || citations.length <= 0) return 0;

    int left = 0, right = citations.length - 1;
    while(left <= right){
      int mid = left + (right -left)/2;
      int num = citations.length - mid;
      if(citations[mid] == num)
        return num;
      else if(citations[mid] > num)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return citations.length - left;
  }
  
  public static void main(String[] args) {
    ld275 l209 = new ld275();
    int a[][] = { {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30} };
    
    int b[] = {0, 1, 3, 5, 6};
    System.out.println(l209.hIndex(b));
    int c[] = {0};
    System.out.println(l209.hIndex(c));
    int d[] = {0, 1, 2, 3, 4, 5};
    System.out.println(l209.hIndex(d));
    int e[] = {0, 1, 2, 3, 4, 5, 6};
    System.out.println(l209.hIndex(e));
    int f[] = {0, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(l209.hIndex(f));
//    for(int i=0;i < 30; ++i){
//      System.out.println( i + " is : " );
//    }
  }
}
