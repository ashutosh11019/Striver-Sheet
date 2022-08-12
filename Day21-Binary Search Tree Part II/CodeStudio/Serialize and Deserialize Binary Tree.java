/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
import java.util.*;

public class Solution {
    public static String serializeTree(TreeNode<Integer> root){
        //    Write your code here for serialization of the tree.
        if (root == null) return "#";
        return root.data + "," + serializeTree(root.left) + "," + serializeTree(root.right);
    }
    
    public static TreeNode<Integer> deserializeTree(String str){
        //    Write your code here for deserialization of the tree.
        Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
        return helper(queue);
    }
    
    private static TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode<Integer> root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
