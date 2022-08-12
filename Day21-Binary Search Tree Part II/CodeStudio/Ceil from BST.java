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
    
    public static int findCeil(TreeNode<Integer> node, int x) {
        // Write your code here
        min = -1;
        ceil(node, x);
        return min;
    }
    
    public static void ceil(TreeNode<Integer> root, int x){
        if(root == null) return;
        if(root.data > x){
            min = root.data;
            ceil(root.left, x);
        }else if(root.data == x){
            min = x;
        }else{
            ceil(root.right, x);
        }
    }
}
