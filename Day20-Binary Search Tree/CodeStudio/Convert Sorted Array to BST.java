/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/

import java.util.*;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        if (arr == null || arr.size() ==0){
            return null;
        }
        return recv(arr, 0, arr.size()-1);
    }
    
    private static TreeNode<Integer> recv(ArrayList<Integer> nums, int start, int end){
        if (start > end){
            return null;
        }
        int middle = start + (end-start)/2;
        TreeNode<Integer> node = new TreeNode(nums.get(middle));
        node.left = recv(nums, start, middle-1);
        node.right = recv(nums, middle+1, end);
        return node;
    }
}