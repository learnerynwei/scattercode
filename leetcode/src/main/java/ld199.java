

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ld199 {

  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null)
      return res;
    List<TreeNode> lln = new LinkedList<>();
    lln.add(null);
    lln.add(root);
    boolean isFirst = false;

    while (lln.size() > 0) {
      TreeNode tmp = lln.remove(0);
      if (tmp == null) {
        isFirst = true;
      } else {
        if (isFirst) {
          res.add(tmp.val);
          lln.add(null);
          isFirst = false;
        }
        if (tmp.right != null)
          lln.add(tmp.right);
        if (tmp.left != null)
          lln.add(tmp.left);
      }
    }
    return res;
  }

  /*
   * The core idea of this algorithm
   * 1.Each depth of the tree only select one node.
   * 2. View depth is current size of result list.
   */
  public List<Integer> rightSideViewOther(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    rightView(root, result, 0);
    return result;
  }

  public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
    if (curr == null) {
      return;
    }
    if (currDepth == result.size()) {
      result.add(curr.val);
    }

    rightView(curr.right, result, currDepth + 1);
    rightView(curr.left, result, currDepth + 1);

  }

  /*
   *void recursion(TreeNode *root, int level, vector<int> &res)
    {
        if(root==NULL) return ;
        if(res.size()<level) res.push_back(root->val);
        recursion(root->right, level+1, res);
        recursion(root->left, level+1, res);
    }

    vector<int> rightSideView(TreeNode *root) {
        vector<int> res;
        recursion(root, 1, res);
        return res;
    }
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for (int i = 0; i < 10; i++) {
      int len = ListUtils.random(0, 12);
      System.out.println("Length is: " + len);
      TreeNode root = TreeUtils.createBST(0, len);
      TreeUtils.levelTraverse(root);
      System.out.println(rightSideView(root));
    }
  }

}
