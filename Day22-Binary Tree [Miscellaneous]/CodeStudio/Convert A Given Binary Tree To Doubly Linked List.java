/*
    Time Complexity - O(N)
    Space Complexity - O(N)

    where 'N' is the number of nodes in the tree.
*/

/*************************************************************
 class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

*************************************************************/

public class Solution {
    
    static BinaryTreeNode<Integer> head = null;
    static BinaryTreeNode<Integer> prev = null;

    public static void findHead(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        findHead(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        findHead(root.right);
    }

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {

        head = null;
        prev = null;
        findHead(root);

        return head;
    }

}
