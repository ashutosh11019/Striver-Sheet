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
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> p = new ArrayList<>();
        if(root==null) return p;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            p.add(root.data);
            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
        return p;
    }
}