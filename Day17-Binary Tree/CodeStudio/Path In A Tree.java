/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer>path = new ArrayList<>();
        getPath(root,x,path);
        Collections.reverse(path);
        return path;
    }
    
    public static boolean getPath(TreeNode node, int key, ArrayList<Integer>path){
        if(node == null){
            return false;
        }
        if(node.data == key){
            path.add(node.data);
            return true;
        }
        boolean res = getPath(node.left,key,path) || getPath(node.right, key,path);
        if(res){
            path.add(node.data);
        }
        return res;
    }
}