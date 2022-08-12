/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
import java.util.*;

public class Solution {

    static class BSTIterator{
        private Stack<TreeNode<Integer>> st = new Stack<>();
        
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            TreeNode<Integer> node = root;
            for(;node != null;st.push(node),node=node.left);
        }

        int next(){
            // Write your code here
            TreeNode<Integer> t = st.pop();
            TreeNode<Integer> node = t.right;
            for(;node != null;st.push(node),node=node.left);
            return t.data;
        }

        boolean hasNext(){
            // Write your code here
            return !st.isEmpty();
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
