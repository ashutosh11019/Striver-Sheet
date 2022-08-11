/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/
import java.util.*;

public class Solution {
    static long max;
    
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        if(root==null || (root.left==null && root.right==null)) return -1;
        max=Long.MIN_VALUE;
        int c=leaves(root);
        if(c<2) return -1;
        maxsum(root);
        return max;
	}
    
    static int leaves(TreeNode root){
         Stack<TreeNode> st = new Stack<>();
         st.push(root);
         int c=0;
         while(!st.isEmpty()){
             TreeNode node = st.pop();
             if(node.left == null && node.right == null) c++;
             if(node.left != null) st.push(node.left);
             if(node.right != null) st.push(node.right);
         }
         return c;
    }
    
    static long maxsum(TreeNode root){
        if(root==null) return 0;
        long l=Math.max(maxsum(root.left),0);
        long r=Math.max(maxsum(root.right),0);
        long sum=root.data+l+r;
        max=Math.max(max, sum);
        return (long)root.data + (long)Math.max(l,r);
    }
}