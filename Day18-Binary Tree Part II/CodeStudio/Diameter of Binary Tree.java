/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
    static int ans=0;
    
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
        ans=0;
        height(root);
        return ans-1;
	}
    
    public static int height(TreeNode<Integer> root){
        if(root==null) return 0;
        int l=height(root.left);
        int r=height(root.right);
        if(ans<(l+r+1)) ans=l+r+1;
        return 1+Math.max(l,r);
    }
}