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
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }
}