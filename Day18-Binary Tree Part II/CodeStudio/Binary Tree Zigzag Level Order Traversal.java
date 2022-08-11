/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/
import java.util.*;
public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<BinaryTreeNode<Integer>> q = new ArrayDeque<>();
        int flag=0;
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<level;i++){
                BinaryTreeNode<Integer> cur=q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                list.add(cur.data);
            }
            if(flag==0){
                for(int num: list) ans.add(num);
                flag=1;
            }else{
                Collections.reverse(list);
                for(int num: list) ans.add(num);
                flag=0;
            }
        }
        return ans;
	}
}
