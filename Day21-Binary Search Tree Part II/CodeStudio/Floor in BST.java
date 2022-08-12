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

public class Solution {
    static int min;
    
    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        min = Integer.MIN_VALUE;
        floor(root, X);
        return min;
    }
    
    public static void floor(TreeNode<Integer> root, int x){
        if(root==null) return;
        if(root.data > x){
            floor(root.left, x);
        }else if(root.data == x){
            min = x;
        }else{
            min = Math.max(min, root.data);
            floor(root.left, x);
            floor(root.right, x);
        }
    }
}