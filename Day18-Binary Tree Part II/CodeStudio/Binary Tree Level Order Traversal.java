/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    //Your code goes here
        Queue<BinaryTreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                list.add(q.poll().val);
            }
        }
        return list;
  }

}