/*************************************************************
    Following is the Binary Tree node structure

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
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        int pred[]={-1};
        int succ[]={-1};

        inorder_predecessor(root,pred,key);
        inorder_successor(root,succ,key);

        ArrayList<Integer> ans= new ArrayList<Integer>();
        ans.add(pred[0]);
        ans.add(succ[0]);
        return ans;
	}
    
    public static void inorder_predecessor(BinaryTreeNode<Integer> root, int[] pred, int key){
        while(root!=null){
            if(root.data<key){
                pred[0]=root.data;
                root=root.right;
            }else if(root.data>=key){
                root=root.left;
            }
        }
    }
    
    public static void inorder_successor(BinaryTreeNode<Integer> root, int[] succ, int key){
        while(root!=null){
            if(root.data>key){
                succ[0]=root.data;
                root=root.left;
            }else if(root.data<=key){
                root=root.right;
            }
        }
    }
}