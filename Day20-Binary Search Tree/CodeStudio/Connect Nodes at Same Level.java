/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/
import java.util.*;

public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
        if(root==null) return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                BinaryTreeNode<Integer> temp=q.peek();
                q.poll();
                if(i==n-1) temp.next=null;
                else temp.next=q.peek();
                if(temp.left!=null)  q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
	}
}