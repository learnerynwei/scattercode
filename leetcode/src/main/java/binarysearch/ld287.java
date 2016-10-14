package leetcode.binarysearch;

public class ld287 {

  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length <= 0)
      return -1;
    int l = 1, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      int count = countLarge(nums, mid);
      if (count <= (nums.length - mid))
        r = mid - 1;
      else
        l = mid + 1;
    }
    return r;
  }

  public int countLarge(int[] nums, int low) {
    int res = 0;
    for (int i : nums)
      if (i >= low)
        res++;
    return res;
  }

  // https://discuss.leetcode.com/topic/25685/java-o-n-time-and-o-1-space-solution-similar-to-find-loop-in-linkedlist
  public int findDuplicateN(int[] nums) {
    int n = nums.length - 1;
    int first = n, second = n;
    while (true) {
      first = nums[first] - 1;
      second = nums[nums[second] - 1]  - 1;
      if (first == second)
        break;
    }

    first = n;
    while (first != second) {
      first = nums[first] - 1;
      second = nums[second] - 1;
    }
    return first + 1;
  }

  public static void main(String[] args) {
    ld287 l209 = new ld287();
    int[] b = { 1, 3, 3, 3, 4, 5 };
    // for (int i = 0; i < 5; i++) {
    // System.out.println(i + " is :" + l209.findDuplicate(b, i) );
    // }
    System.out.println(l209.findDuplicateN(b));
    int[] c = { 1, 2, 3, 4, 5, 7, 7, 7, 7, 7 };

    System.out.println(l209.findDuplicateN(c));
    
    int[] d = { 2, 1,1 };
    System.out.println(l209.findDuplicateN(d));
    // for (int i = 0; i < 8; i++) {
    // System.out.println(i + " is :" + l209.findDuplicate(c, i) );
    // }
    // for(int i = 1; i < 20; ++i)
    // System.out.println("sum is " + i + ", result is " +
    // l209.minSubArrayLen(i, b));
    //
  }

}
