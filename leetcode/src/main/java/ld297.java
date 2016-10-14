import java.util.List;

public class ld297 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) return "";
    return serialize(root, 1);
  }

  private String serialize(TreeNode root, int i) {
    if (root == null)
      return "";
    String left = serialize(root.left, 2 * i);
    String right = serialize(root.right, 2 * i + 1);
    return i + "," + root.val + (left.equals("") ? "" : " " + left) 
        + (right.equals("") ? "" : " " + right) ;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.equals("")) return null;
    return deserialize(data, 1, 0, data.length() - 1);
  }

  private TreeNode deserialize(String data, int i, int start, int end) {
    int dotIn = data.indexOf(',', start);
    int spaIn = data.indexOf(' ', start);
    int val = Integer.parseInt(data.substring(dotIn+1, spaIn < 0 || spaIn > end ? end + 1 : spaIn));
    TreeNode root = new TreeNode(val);
    int leftIn = data.indexOf(" " + 2*i + "," );
    int rightIn = data.indexOf(" " + (2*i + 1) + "," );
    if(leftIn > 0){
      root.left = deserialize(data, 2*i, spaIn + 1, rightIn > 0 ? rightIn - 1 : end);
    }
    if(rightIn > 0 ){
      root.right = deserialize(data, 2*i + 1, rightIn + 1, end);
    }
    return root;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    System.out.println("1234".indexOf('2'));
//    System.out.println("1234".substring(0, 4));
    TreeNode root = TreeUtils.createBST(0, 10);
    TreeUtils.levelTraverse_r(root);
    ld297 ld = new ld297();
    String ser = ld.serialize(root);
    System.out.println(ser);
    root = ld.deserialize(ser);
    TreeUtils.levelTraverse_r(root);
  }

}
