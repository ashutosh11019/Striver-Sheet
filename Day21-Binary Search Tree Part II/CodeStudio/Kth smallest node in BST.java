/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution {
    static int ans;
    
    static void inorder(TreeNode<Integer> root, int[] k) {
        if (root==null) return;
        inorder(root.left, k);
        k[0]--;
        if (k[0] == 0){
            ans = root.data;
            return;
        } 
        inorder(root.right, k);
    }
    
	public static int kthSmallest(TreeNode<Integer> root, int k) {
		//  Write your code here.
        ans = 0;
        inorder(root, new int[]{k});
        return ans;
	}

}
