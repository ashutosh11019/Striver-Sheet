/************************************************************

    Following is the TreeNode class structure.

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
import java.util.*;
public class Solution {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root){
        // Write your code here.
        if(root==null) return root;
        Stack<TreeNode<Integer>> st = new Stack<>();
        st.add(root);
        TreeNode<Integer> cur = root;
        TreeNode<Integer> r = cur;
        while(!st.isEmpty()){
            cur=st.peek();
            st.pop();
            if(cur.right!=null) st.add(cur.right);
            if(cur.left!=null) st.add(cur.left);
            if(!st.isEmpty()) cur.right = st.peek();
            cur.left=null;
        }
        return r;
    }
}