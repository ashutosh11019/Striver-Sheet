/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean helper(BinaryTreeNode<Integer> node, long min, long max){
        if(node==null) return true;
        if(node.data>=min && node.data<=max) return (helper(node.left,min,node.data) && helper(node.right,node.data,max));
        else return false;
        
        
    }
}
