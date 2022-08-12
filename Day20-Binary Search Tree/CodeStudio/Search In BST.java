/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
        if(root.data == x) return true;
        while(root != null){
            if(root.data == x) return true;
            else if(root.data < x) root=root.right;
            else root=root.left;
        }
        return false;
	}
}