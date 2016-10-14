

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ld257 {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new LinkedList<>();
    List<TreeNode> st = new LinkedList<>();
    TreeNode p = root;
    while (p != null) {
      st.add(p);
      p = p.left;
    }

    while (!st.isEmpty()) {
      p = st.remove(st.size() - 1);
      if (p == null) {
        st.remove(st.size() - 1);
        continue;
      }

      if (p.left == null && p.right == null) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode tmp : st) {
          if (tmp != null)
            sb.append(tmp.val + "->");
        }
        sb.append(p.val);
        res.add(sb.toString());
      }

      if (p.right != null) {
        st.add(p);
        st.add(null);
      }
      p = p.right;
      while (p != null) {
        st.add(p);
        p = p.left;
      }
    }
    return res;
  }

  public List<String> binaryTreePaths_Other(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null)
      searchBT(root, "", answer);
    return answer;
  }

  private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null)
      answer.add(path + root.val);
    if (root.left != null)
      searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null)
      searchBT(root.right, path + root.val + "->", answer);
  }

  public List<String> binaryTreePaths_O2(TreeNode root) {

    List<String> paths = new LinkedList<>();

    if (root == null)
      return paths;

    if (root.left == null && root.right == null) {
      paths.add(root.val + "");
      return paths;
    }

    for (String path : binaryTreePaths(root.left)) {
      paths.add(root.val + "->" + path);
    }

    for (String path : binaryTreePaths(root.right)) {
      paths.add(root.val + "->" + path);
    }

    return paths;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    TreeNode root = TreeUtils.createBST(0, 10);
    List<TreeNode> nodes = TreeUtils.levelTraverse_r(root);
    List<String> strs = new ld257().binaryTreePaths(root);
    for (Iterator iterator = strs.iterator(); iterator.hasNext();) {
      String string = (String) iterator.next();
      System.out.println(string);
    }
  }

}
