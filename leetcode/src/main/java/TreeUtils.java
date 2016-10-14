
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sun.reflect.generics.tree.Tree;

public class TreeUtils {
  public static TreeNode createBST(int start, int end) {
    if (start > end)
      return null;
    if (start == end)
      return new TreeNode(start);
    int rand = ListUtils.random(start, end);
    TreeNode root = new TreeNode(rand);
    root.left = createBST(start, rand - 1);
    root.right = createBST(rand + 1, end);
    return root;
  }

  public static TreeNode createCBT(int nodeNum) {
    if( nodeNum <= 0) return null;
    int count = 0;
    LinkedList<TreeNode> tq = new LinkedList<>(); 
    TreeNode root = new TreeNode(count++);
    tq.add(root);
    while( !tq.isEmpty() && count < nodeNum){
      TreeNode  p = tq.removeFirst();
      if(count < nodeNum){
        p.left = new TreeNode(count++);
        tq.add(p.left);
      }
      if( count < nodeNum){
        p.right = new TreeNode(count++);
        tq.add(p.right);
      }
    }
    return root;
  }
  public static void levelTraverse(TreeNode root) {
    LinkedList<TreeNode> ll = new LinkedList<>();
    if (root == null)
      System.out.println("NULL");
    ll.add(root);
    ll.add(null);

    while (ll.size() > 0) {
      TreeNode tmp = ll.removeFirst();
      if (tmp == null) {
        System.out.println();
        if (ll.size() > 0)
          ll.add(null);
      } else {
        System.out.print(tmp.val + "\t");
        if (tmp.left != null)
          ll.add(tmp.left);
        if (tmp.right != null)
          ll.add(tmp.right);
      }
    }
  }

  public static List<TreeNode> levelTraverse_r(TreeNode root) {
    LinkedList<TreeNode> ll = new LinkedList<>();
    List<TreeNode> arrNode = new ArrayList<>();
    if (root == null) {
      System.out.println("NULL");
      return arrNode;
    }
    ll.add(root);
    ll.add(null);

    while (ll.size() > 0) {
      TreeNode tmp = ll.removeFirst();
      if (tmp == null) {
        System.out.println();
        if (ll.size() > 0)
          ll.add(null);
      } else {
        System.out.print(tmp.val + "\t");
        arrNode.add(tmp);
        if (tmp.left != null)
          ll.add(tmp.left);
        if (tmp.right != null)
          ll.add(tmp.right);
      }
    }
    return arrNode;
  }
}


