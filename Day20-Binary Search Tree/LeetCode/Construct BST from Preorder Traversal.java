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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    public static TreeNode build(int[] arr, int n, int[] a){
        if(a[0] == arr.length || arr[a[0]]>n) return null;
        TreeNode root = new TreeNode(arr[a[0]++]);
        root.left = build(arr, root.val, a);
        root.right = build(arr, n, a);
        return root;
    }
}