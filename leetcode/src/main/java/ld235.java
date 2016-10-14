

public class ld235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if( root == null) return null;
    int max = Math.max(p.val, q.val);
    int min = Math.min(p.val, q.val);
    TreeNode cur = root;
    while( cur != null){
      if(cur.val >= min && cur.val <= max){
        return cur;
      }else if(cur.val > max){
        cur = cur.left;
      }else{
        cur = cur.right;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
