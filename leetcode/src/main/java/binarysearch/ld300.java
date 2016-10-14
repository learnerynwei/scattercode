package leetcode.binarysearch;

import java.util.Arrays;

public class ld300 {

  //https://discuss.leetcode.com/topic/39681/fast-java-binary-search-solution-with-detailed-explanation
  //https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation/2
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length <= 0)
      return 0;
    int[] tails = new int[nums.length];
    int len = 0;
    for (int i : nums) {
      if (len == 0 || tails[len - 1] < i )
        tails[len++] = i;
      else {
        int ind = Arrays.binarySearch(tails, 0, len, i);
        if(ind < 0) ind = -(ind + 1);
        if (tails[ind] > i)
          tails[ind] = i;
      }
    }
    return len;
  }

  public static void main(String[] args) {
    int a[] = {10, 9, 2, 5, 3, 7, 101, 18, 4, 5};
    ld300 ld = new ld300();
    System.out.println(ld.lengthOfLIS(a));
  }

}
