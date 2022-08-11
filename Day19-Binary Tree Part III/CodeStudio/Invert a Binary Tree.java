/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
import java.util.Stack;

public class Solution {
    private static boolean helper(TreeNode<Integer> root, Stack<TreeNode<Integer>> st, TreeNode<Integer> leaf) {
        st.push(root);
        if (root.left == null && root.right == null) {
            if (root.data.intValue() == leaf.data.intValue()) {
                return true;
            }
            else {
                st.pop();
                return false;
            }
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = helper(root.left, st, leaf);
        }
        if (left) {
            return true;
        }
        if (root.right != null) {
            right = helper(root.right, st, leaf);
        }
        if (right) {
            return true;
        }
        st.pop();
        return false;
    }

    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode<Integer>> st = new Stack<TreeNode<Integer>>();
        helper(root, st, leaf);
        TreeNode<Integer> newRoot = st.peek();
        st.pop();
        TreeNode<Integer> parent = newRoot;
        while (!st.isEmpty()) {
            TreeNode<Integer> curNode = st.peek();
            st.pop();
            if (curNode.left == parent) {
                curNode.left = null;
                parent.left = curNode;
            } else {
                curNode.right = curNode.left;
                curNode.left = null;
                parent.left = curNode;
            }
            parent = parent.left;
        }
        return newRoot;
    }
}
