/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) { 
            return ;
        }
        
        if(root.left == null && root.right == null) {
            return ;
        }
        
        if(root.left != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        flatten(root.left);
        flatten(root.right);
        
		
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        while(right.right != null) {
            right = right.right;
        }
        
        right.right = left;
        root.left = null;
        return ;
    }
}