/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {
    private static boolean checkSymmetricity(BinaryTreeNode<Integer> firstRoot, BinaryTreeNode<Integer> secondRoot) {
        if(firstRoot == null && secondRoot == null) {
            return true;
        }
        if( (firstRoot == null && secondRoot != null) || (firstRoot != null && secondRoot == null) ) {
            return false;
        }
        if(!firstRoot.data.equals(secondRoot.data)) {
            return false;
        }
        return checkSymmetricity(firstRoot.right, secondRoot.left) && checkSymmetricity(firstRoot.left, secondRoot.right);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return checkSymmetricity(root, root); 
    }
}