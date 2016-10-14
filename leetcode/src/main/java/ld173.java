
import java.util.Stack;

public class ld173 {
  private Stack<TreeNode> st = new Stack<TreeNode>(); 
  
  public ld173(TreeNode root) {
    if( root == null ) return;
    TreeNode p = root;
    while( p != null ){
      st.push(p);
      p = p.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !st.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    if(st.isEmpty() ) return -1;
    TreeNode p = st.pop();
    int res = p.val;
    p = p.right;
    while( p != null){
      st.push(p);
      p = p.left;
    }
    return res;
  }
  
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      int len = ListUtils.random(0, 12);
      System.out.println("Length is: " + len);
      ld173 ld = new ld173(TreeUtils.createBST(0, len));
      while( ld.hasNext() ){
        System.out.print(ld.next() + "\t");
      }
      System.out.println();
    }
  }
}
