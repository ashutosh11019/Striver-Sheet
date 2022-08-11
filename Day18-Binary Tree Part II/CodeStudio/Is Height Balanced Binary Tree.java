/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {
    static boolean result;

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        // Write your code here.
        result = true;
        int temp = maxDepth(root);
        return result;
    }
    
    public static int maxDepth(BinaryTreeNode<Integer> root) {
        if(root==null)
            return 0;
        if(!result)
            return 0;
        int leftSubTree = maxDepth(root.left);
        int rightSubTree = maxDepth(root.right);
        if(Math.abs(leftSubTree-rightSubTree) > 1){
            result = false;
        }
        return 1 + Math.max(leftSubTree, rightSubTree);
    }
}
