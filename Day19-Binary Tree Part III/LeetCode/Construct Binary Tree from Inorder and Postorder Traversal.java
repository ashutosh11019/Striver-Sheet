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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i], i);
        return help(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    
    public static TreeNode help(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int r = map.get(postorder[pe]);
        TreeNode left = help(inorder, is, r-1, postorder, ps, ps+r-is-1, map);
        TreeNode right = help(inorder, r+1, ie, postorder, ps+r-is, pe-1, map);
        root.left = left;
        root.right = right;
        return root;
    }
}