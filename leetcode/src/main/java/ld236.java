

import java.util.List;

public class ld236 {

  private static TreeNode result = null;

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    result = null;
    TreeNode res = null;
    lowestCommonAncestor(root, p, q, res);
    return result;
  }

  private static int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode res) {
    // TODO Auto-generated method stub
    if (root == null)
      return 0;
    if (result != null)
      return 2;
    if (p.equals(root) && q.equals(root)) {
      result = root;
      return 2;
    }
    int left = lowestCommonAncestor(root.left, p, q, res);
    if (1 == left && (p.equals(root) || q.equals(root))) {
      result = root;
      return 2;
    }
    int right = lowestCommonAncestor(root.right, p, q, res);
    if (1 == right && (1 == left || p.equals(root) || q.equals(root))) {
      result = root;
      return 2;
    }
    return left + right + (p.equals(root) ? 1 : 0) + (q.equals(root) ? 1 : 0);
  }

  //十分精妙，只要有相等的就返回，不单独考虑有几个相等，非常灵活的运用了后序遍历
  //return 语句是遍历的过程。 左右都不为空，则返回root，否则右为空，返回左，左为空，返回右。
  public TreeNode lowestCommonAncestor_Other(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;
    TreeNode left = lowestCommonAncestor_Other(root.left, p, q);
    TreeNode right = lowestCommonAncestor_Other(root.right, p, q);
//    if(left != null && right != null)   return root;
//    return left != null ? left : right;
    return left == null ? right : right == null ? left : root;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TreeNode root = TreeUtils.createBST(0, 15);
    List<TreeNode> nodes = TreeUtils.levelTraverse_r(root);
    for (int i = 0; i < 10; i++) {
      TreeNode tmp = lowestCommonAncestor(root, nodes.get(ListUtils.random(0, nodes.size() - 1)),
          nodes.get(ListUtils.random(0, nodes.size() - 1)));
      if (tmp != null)
        System.out.println(tmp.val);
      else
        System.out.println("NULL");
    }
  }

}
