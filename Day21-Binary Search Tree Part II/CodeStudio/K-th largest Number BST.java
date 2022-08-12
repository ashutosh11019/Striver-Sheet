/*************************************************************
    Following is the Binary Search Tree node structure

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

*************************************************************/

import java.util.*;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
        Stack<TreeNode<Integer>> st = new Stack<>();
        int cnt=0;
        while(true){
            if(root != null){
                st.add(root);
                root=root.right;
            }
            else{
                if(st.isEmpty()) break;
                root=st.peek();
                st.pop();
                cnt++;
                if(cnt==k)
                    return root.data;
                root=root.left;
            }
        }
        return -1;
	}
}