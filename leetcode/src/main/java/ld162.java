

import java.util.List;

public class ld162 {
  
  public static int findPeakElement1(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if(nums[i] < nums[i-1])
        return i - 1;
    }
    return nums.length - 1;
  }
  
  /*
   * Lets say you have a mid number at index x, nums[x] 
   * if (num[x+1] > nums[x]), 
   *   that means a peak element HAS to exist on the right half of that array, 
   *   because (since every number is unique) 
   *   1. the numbers keep increasing on the right side, 
   *   and the peak will be the last element. 
   *   2. the numbers stop increasing and there is a 'dip', 
   *   or there exists somewhere a number 
   *   such that nums[y] < nums[y-1], 
   *   which means number[x] is a peak element.
   * This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
   */
  public static int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while( low < high){
      int mid = low + (high - low)/2;
      int mid2 = mid + 1;
      if( nums[mid] > nums[mid2])
        high = mid;
      else
        low = mid2;
    }
    return low;
  }
  
  public static void main(String[] args) {
    for(int i=0; i < 10; ++i){
      System.out.println("Round " + i);
      int nums[] = new int[ListUtils.random() + 1];
      ArrayUtils.createArray(nums);
      System.out.println("method 1: " + findPeakElement(nums));
      System.out.println("method 2: " + findPeakElement1(nums));
    }
  }

}
