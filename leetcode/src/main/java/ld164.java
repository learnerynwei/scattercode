

import java.util.Arrays;

public class ld164 {
  //坑太多
  //1.别忘了最小值和最大值不放入bucket中，但最后算最值别忘了。
  //2.计算range时需要先转义成double类型，要不就成向下取整。
  //3.bucket中存原值，计算用原值；bucket中存差值，计算用差值。

  /*
   * 解析如下：
   * Suppose there are N elements in the array, 
   * the min value is min and the max value is max. 
   * Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
   * Let gap = ceiling[(max - min ) / (N - 1)]. 
   * We divide all numbers in the array into n-1 buckets, 
   * where k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap). 
   * Since there are n-2 numbers that are not equal ***min*** or ***max*** 
   * and there are n-1 buckets, 
   * at least one of the buckets are empty. 
   * We only need to store the largest number and the smallest number in each bucket.
   */
  public static int maximumGap(int[] nums) {
    int n = nums.length;
    if( n < 2) return 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i=0;i < n; ++i){
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }
    
    int burkMax[] = new int[n];
    int burkMin[] = new int[n];
    for (int i = 0; i < burkMin.length; i++) {
      burkMax[i] = Integer.MIN_VALUE;
      burkMin[i] = Integer.MAX_VALUE;
    }
    
    int range = (int)Math.ceil((double)(max - min)/(n-1));
    for (int i = 0; i < n; i++) {
      //妙
      if( nums[i] == min || nums[i] == max) 
        continue;
      int dis = nums[i] - min;
      int index = dis/range;
      burkMax[index] = Math.max(burkMax[index], dis);
      burkMin[index] = Math.min(burkMin[index], dis);
    }
    
    int res = Integer.MIN_VALUE;
    int pre = 0;//不能burkMax[0]
    for(int i = 0; i < n; ++i ){
      if( burkMin[i] == Integer.MAX_VALUE)
        continue;
      res = Math.max(burkMin[i] - pre, res);
      pre = burkMax[i];
    }
    //import
    res = Math.max(res, max - min - pre);
    return res;
  }
  
  public static int maximumGapOther(int[] num) {
    if (num == null || num.length < 2)
        return 0;
    // get the max and min value of the array
    int min = num[0];
    int max = num[0];
    for (int i:num) {
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    // the minimum possibale gap, ceiling of the integer division
    int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
    int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
    int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
    // put numbers into buckets
    for (int i:num) {
        if (i == min || i == max)
            continue;
        int idx = (i - min) / gap; // index of the right position in the buckets
        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
    }
    // scan the buckets for the max gap
    int maxGap = Integer.MIN_VALUE;
    int previous = min;
    for (int i = 0; i < num.length - 1; i++) {
        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
            // empty bucket
            continue;
        // min value minus the previous value is the current gap
        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
        // update previous bucket value
        previous = bucketsMAX[i];
    }
    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
    return maxGap;
}
  
  public static void main(String[] args) {
    for(int i=0;i < 10; ++i){
      int nums[] = new int[ListUtils.random(0, 20)];
      ArrayUtils.createArray(nums, 0, 100, false);
      System.out.println(maximumGap(nums)== maximumGapOther(nums));
    }
  }

}
