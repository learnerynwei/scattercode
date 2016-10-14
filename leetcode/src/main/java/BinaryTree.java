/**
 * Created by wyn on 2016/9/26.
 */

import java.util.Stack;


public class BinaryTree {

    public static void PreOrderTraversalR(TreeNode root) {
        if (root == null)
            return;
        BinaryTree.visite(root);
        if (root.left != null)
            PreOrderTraversalR(root.left);
        if (root.right != null)
            PreOrderTraversalR(root.right);
    }

    public static void InOrderTraversalR(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            InOrderTraversalR(root.left);
        BinaryTree.visite(root);
        if (root.right != null)
            InOrderTraversalR(root.right);
    }

    public static void PostOrderTraversalR(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            PostOrderTraversalR(root.left);
        if (root.right != null)
            PostOrderTraversalR(root.right);
        BinaryTree.visite(root);
    }

    public static void PreOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            BinaryTree.visite(node);
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);
        }
    }

    public static void InOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            st.push(node);
            node = node.left;
        }
        while (!st.isEmpty()) {
            node = st.pop();
            BinaryTree.visite(node);
            node = node.right;
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }
    }

    public static void PostOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            st.push(node);
            node = node.left;
        }
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            if (cur == null) {
                cur = st.pop();
                BinaryTree.visite(cur);
                continue;
            }

            st.push(cur);
            st.push(null);

            node = cur.right;
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }
    }

    public static void PreOrderTraversal_T(TreeNode root) {
        if (root == null)
            return;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                BinaryTree.visite(cur);
                cur = cur.right;
                continue;
            }

            TreeNode pre = cur.left;
            while (pre.right != null) {
                if (pre.right == cur)
                    break;
                pre = pre.right;
            }

            if (pre.right == cur) {
                pre.right = null;
                cur = cur.right;
            } else {
                BinaryTree.visite(cur);
                pre.right = cur;
                cur = cur.left;
            }
        }
    }

    public static void InOrderTraversal_T(TreeNode root) {
        if (root == null)
            return;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                BinaryTree.visite(cur);
                cur = cur.right;
                continue;
            }

            TreeNode pre = cur.left;
            while (pre.right != null) {
                if (pre.right == cur)
                    break;
                pre = pre.right;
            }

            if (pre.right == cur) {
                BinaryTree.visite(cur);
                pre.right = null;
                cur = cur.right;
            } else {
                pre.right = cur;
                cur = cur.left;
            }
        }
    }

    public static void PostOrderTraversal_T(TreeNode root) {
        if (root == null)
            return;
    }

    private static void visite(TreeNode root) {
        // TODO Auto-generated method stub
        if (root == null)
            System.out.print("NULL ");
        else
            System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = TreeUtils.createBST(0, 10);
        TreeUtils.levelTraverse(root);
        System.out.println("\nPreOrder :");
        BinaryTree.PreOrderTraversal(root);
        System.out.println("\nPreOrder Re :");
        BinaryTree.PreOrderTraversalR(root);
        System.out.println("\nInOrder :");
        BinaryTree.InOrderTraversal(root);
        System.out.println("\nInOrder Re :");
        BinaryTree.InOrderTraversalR(root);
        System.out.println("\nPostOrder :");
        BinaryTree.PostOrderTraversal(root);
        System.out.println("\nPostOrder Re:");
        BinaryTree.PostOrderTraversalR(root);

        System.out.println("\nPreOrder Th :");
        BinaryTree.PreOrderTraversal_T(root);
        System.out.println("\nInOrder Th :");
        BinaryTree.InOrderTraversal_T(root);
        System.out.println("\nPostOrder Th :");
        BinaryTree.PostOrderTraversal_T(root);
    }
}
//
// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
//
// TreeNode(int v) {
// val = v;
// }
// }

