/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer>path = new ArrayList<>();
        getPath(A,B,path);
        Collections.reverse(path);
        return path;
    }
    public boolean getPath(TreeNode node, int key, ArrayList<Integer>path){
        if(node == null){
            return false;
        }
        if(node.val == key){
            path.add(node.val);
            return true;
        }
        boolean res = getPath(node.left,key,path) || getPath(node.right, key,path);
        if(res){
            path.add(node.val);
        }
        return res;
    }
}

