/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/

public class Solution {
    static int[] largeBST(TreeNode<Integer> root){
        if(root==null)  return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] l = largeBST(root.left);
        int[] r = largeBST(root.right);
        if(l[2]<root.data && root.data<r[1])
            return new int[]{1+l[0]+r[0], Math.min(l[1],root.data), Math.max(r[2],root.data)};
        else
            return new int[]{Math.max(l[0],r[0]), Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
    
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
        int[] temp = largeBST(root);
        return temp[0];
	}
}
