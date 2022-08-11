/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;

public class Solution {
    static class Pair{
        int hd;
        BinaryTreeNode node;
        public Pair(int hd, BinaryTreeNode node){
            this.node = node;
            this.hd = hd;
        }
    }
    
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        if(root == null) return new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)) map.put(cur.hd, cur.node.val);
            if(cur.node.left != null) q.add(new Pair(cur.hd-1, cur.node.left));
            if(cur.node.right != null) q.add(new Pair(cur.hd+1, cur.node.right));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr.add(entry.getValue());
        }
        return arr;
	}
}