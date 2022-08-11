/************************************************************

    Following is the Binary Tree node structure:
    
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
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
	}
    
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(TreeNode root, ArrayList < Integer > res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    static void addRightBoundary(TreeNode root, ArrayList < Integer > res) {
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(TreeNode root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
}