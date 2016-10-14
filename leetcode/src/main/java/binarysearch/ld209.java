package binarysearch;

public class ld209 {

  // https://discuss.leetcode.com/topic/26814/o-n-o-nlogn-solutions-both-o-1-space/2
  public int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    if (n <= 0)
      return 0;
    int i = 0, j = 1;
    int sum = nums[0];
    int minLen = Integer.MAX_VALUE;

    while (i < j && j < n) {
      if (sum < s) {
        sum += nums[j++];
      } else if (sum > s) {
        if (j - i < minLen)
          minLen = j - i;
        sum -= nums[i++];
      } else if (sum == s) {
        if (j - i < minLen)
          minLen = j - i;
        sum += nums[j++];
      }
      if (i == j) {
        sum = nums[i];
        j++;
      }
    }
    if(j == n) {
      while( sum >= s ){
        if( j - i < minLen)
          minLen = j - i;
        sum -= nums[i++];
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
  // two points, 
  public int minSubArrayLen2(int s, int[] nums) {
    int n = nums.length;
    int i=0, j = 0, sum = 0, min = Integer.MAX_VALUE;
    
    while(j < n){
      sum += nums[j++];
      if(sum >= s){
        while(sum >= s)
          sum -= nums[i++];
        min = Math.min(min, j - i + 1);
        
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] a = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };

    int[]  b = {2, 3, 1, 2, 4, 3};
    int[]  c = {5, 1, 3 , 5, 10,7,4,9,2,8};
    ld209 l209 = new ld209();
    System.out.println(l209.minSubArrayLen2(15, c)); 
//    for(int i = 1; i < 20; ++i)
//      System.out.println("sum is " + i + ", result is " + l209.minSubArrayLen(i, b));
//    
  }

}
