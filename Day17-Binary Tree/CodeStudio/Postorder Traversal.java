/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/
import java.util.*;
public class Solution {
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	// Write your code here.
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postorder = new ArrayList<>();
        if(root == null) return postorder;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            postorder.add(st2.pop().data);
        }
        return postorder;
    }
}