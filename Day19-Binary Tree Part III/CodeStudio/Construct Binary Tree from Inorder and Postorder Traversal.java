/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/
import java.util.*;
public class Solution {
	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postorder, int[] inorder) {
		// Write your code here.
        return Tree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}
    
    public static TreeNode<Integer> Tree(int[] in, int x, int y, int[] po, int a, int b){
        if(x > y || a > b) return null;
        TreeNode<Integer> node = new TreeNode(po[b]);
        int SI = x;  
        while(node.data != in[SI]) SI++;
        node.left  = Tree(in,x,SI-1,po,a,a+SI-x-1);
        node.right = Tree(in,SI+1,y,po,a+SI-x,b-1);
        return node;
    }
}
