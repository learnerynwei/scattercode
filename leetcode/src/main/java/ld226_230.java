

import java.util.Stack;

public class ld226_230 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode tmp = root.right;
    root.right = root.left;
    root.left = tmp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  // ld230
  public static int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> st = new Stack<>();
    if (root == null)
      return -1;
    TreeNode tmp = root;
    while (tmp != null) {
      st.push(tmp);
      tmp = tmp.left;
    }
    int count = 0;
    while (st.size() > 0) {
      tmp = st.pop();
      count++;
      if (count == k)
        return tmp.val;
      tmp = tmp.right;
      while (tmp != null) {
        st.push(tmp);
        tmp = tmp.left;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ld226_230 ld = new ld226_230();
    for (int i = 0; i < 10; i++) {
      int len = ListUtils.random(0, 12);
      System.out.println("Length is: " + len);
      TreeNode root = TreeUtils.createBST(0, len);
      // TreeUtils.levelTraverse(root);
      int k = ListUtils.random(1, len+1);
      System.out.println(k);
      System.out.println(kthSmallest(root, k));
    }
  }
}
