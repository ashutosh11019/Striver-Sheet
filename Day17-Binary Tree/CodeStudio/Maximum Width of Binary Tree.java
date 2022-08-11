/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.util.*;

public class Solution {
	public static int getMaxWidth(TreeNode root) {
		// Write your code here.
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;
        while(!q.isEmpty()){
            int n = q.size();
            cnt = Math.max(cnt, n);

            for(int i = 0; i < n; i++){
                TreeNode tmp = q.peek();
                q.poll();
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
            }
        }

        return cnt;
	}
}