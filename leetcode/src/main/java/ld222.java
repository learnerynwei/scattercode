public class ld222 {

  // Time Limit Exceeded
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    int highl = 0, highr = 0;
    TreeNode p = root;
    while (p != null) {
      highl++;
      p = p.left;
    }
    p = root;
    while (p != null) {
      highr++;
      p = p.right;
    }
    if (highl == highr)
      return (1 << highl) - 1;
    int left = 0, right = (1 << (highl - 1)) - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      int i = 2;
      int num = mid;
      p = root;
      while (true) {
        // if (p != null)
        // count++;
        // else
        // break;
        if (highl < i) {
          count += (p != null ? 1 : 0);
          break;
        }
        int tmp = 1 << highl - i;
        if (tmp == 0 || num / tmp == 0) {
          p = p.left;
        } else {
          p = p.right;
        }
        count++;
        num %= tmp;
        i++;
      }
      if (count >= highl)
        left = mid + 1;
      else
        right = mid;
    }

    return (1 << (highl - 1)) - 1 + left;
  }

  // https://discuss.leetcode.com/topic/21317/accepted-easy-understand-java-solution
  public int countNodes2(TreeNode root) {
    if (root == null)
      return 0;
    int ldepth = getLeftDepth(root.left);
    int rdepth = getRightDepth(root.right);
    int result = 0;
    if (ldepth == rdepth)
      result = (1 << (ldepth + 1)) - 1;
    else
      result = 1 + countNodes2(root.left) + countNodes2(root.right);
    return result;
  }

  private int getRightDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.right;
    }

    return depth;
  }

  private int getLeftDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.left;
    }

    return depth;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    if (k <= 0)
      return new int[0];
    int[] res = new int[k];
    maxNumber(nums1, 0, nums2, 0, k, res);
    return res;
  }

  public void maxNumber(int[] nums1, int step1, int[] nums2, int step2, int k, int[] res) {
    if (k <= 0)
      return;
    int max = 0, ind = -1;
    boolean isFirst = false;
    int up1 = Math.min(nums1.length - k + nums2.length - step2 - 1, nums1.length);
    int up2 = Math.min(nums2.length - k + nums1.length - step1 - 1, nums2.length);
    for (int i = step1; i < up1; ++i) {
      if (max < nums1[i]) {
        max = nums1[i];
        ind = i;
        isFirst = true;
      }
    }
    for (int i = step2; i < up2; ++i) {
      if (max < nums2[i]) {
        max = nums2[i];
        ind = i;
        isFirst = false;
      }
    }
    res[res.length - k] = max;
    if (isFirst) {
      maxNumber(nums1, ind + 1, nums2, step2, k - 1, res);
    } else {
      maxNumber(nums1, step1, nums2, ind + 1, k - 1, res);
    }
  }

  public static void main(String[] args) {
    ld222 l209 = new ld222();
    // for (int i = 0; i < 30; i++) {
    // TreeNode root = TreeUtils.createCBT(i);
    // System.out.println(l209.countNodes(root));
    // }

    int[] a = { 3, 4, 6, 5 };
    int[] b = { 9, 1, 2, 5, 8, 3 };
    l209.maxNumber(a, b, 5);
  }

}
