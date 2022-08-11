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
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        //    Write your code here.
         Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.size();i++) map.put(inorder.get(i),i);
        TreeNode<Integer> root = build(map,preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
        return root;
    }
    
    public static TreeNode build(Map<Integer,Integer> map, ArrayList<Integer> preorder, int prestart, int preend, ArrayList<Integer> inorder, int instart, int inend){
        if(prestart>preend || instart>inend) return null;
        TreeNode<Integer> root = new TreeNode(preorder.get(prestart));
        int data=map.get(root.data);
        int num=data-instart;
        root.left = build(map, preorder, prestart+1, prestart+num, inorder, instart, data-1);
        root.right = build(map, preorder, prestart+num+1, preend, inorder, data+1, inend);
        return root;
    }
}