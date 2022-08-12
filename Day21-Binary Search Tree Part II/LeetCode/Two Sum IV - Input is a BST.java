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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return util(root,k,set);
    }
    
    public boolean util(TreeNode root, int k, Set<Integer> set){
        if(root==null) return false;
        if(util(root.left,k,set)==true) return true;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return util(root.right,k,set);
    }
}