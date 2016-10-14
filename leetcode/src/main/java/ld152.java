import java.math.*;

public class ld152 {

  public static int maxProduct(int[] nums) {
    int length = nums.length;
    if (length <= 0)
      return 0;
    int[] amax = new int[length];
    int[] amin = new int[length];

    amax[0] = nums[0];
    amin[0] = nums[0];
    for (int i = 1; i < length; ++i) {
      amax[i] = Math.max(Math.max(nums[i], nums[i] * amax[i - 1]), nums[i] * amin[i - 1]);
      amin[i] = Math.min(Math.min(nums[i], nums[i] * amax[i - 1]), nums[i] * amin[i - 1]);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < length; ++i) {
      max = Math.max(max, amax[i]);
    }
    return max;
  }

  public static int maxProduct2(int[] nums) {
    if (nums == null)
      return 0;
    return subMaxPro(nums, 0, nums.length - 1);
  }

  //p2  nums[0]*
  public static int subMaxPro(int[] nums, int start, int end) {
    if (start > end)
      return 0;
    if (start == end)
      return nums[start];
    int p1 = 1, p2 = 1, p3 = 0;
    int count = 0;
    for (int i = start; i <= end; i++) {
      if (nums[i] == 0) {
        if (count % 2 == 0) {
          return Math.max(i == start ? 0 : p1, subMaxPro(nums, i + 1, end));
        }
        return Math.max(i - start == 1 ? 0 : Math.max(p1 / p2, p3), subMaxPro(nums, i + 1, end));
      } else {
        p1 *= nums[i];
        if (nums[i] < 0) {
          if (count == 0)
            p2 = p1;
          count++;
        }
        if (count % 2 == 0)
          p3 = p1;
      }
    }
    return Math.max(p1 / p2, p3);
  }
  
  public static void createArray(int nums[]){
    if(nums == null || nums.length == 0) return;
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) Math.round(Math.random()*10) - 5;
      System.out.print(nums[i] + " ");
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for (int i = 3; i < 10; i++) {
      int[] nums = new int[i];
      for( int j=0; j < 4; j++){
        createArray(nums);
        System.out.println();
        System.out.println("my: " + maxProduct(nums) + "; other: " + maxProduct2(nums));
        System.out.println( maxProduct(nums) == maxProduct2(nums));
      }      
    }
  }
}
