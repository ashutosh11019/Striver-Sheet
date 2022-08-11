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

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        View(root, list, 0);
        return list;
    }
    
    public static void View(TreeNode curr, ArrayList<Integer> list, int level){
        if(curr == null) return;
        if(list.size() == level) list.add((int)curr.data);
        View(curr.left, list, level+1);
        View(curr.right, list, level+1);
    }
}
