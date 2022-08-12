 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
        return build(preOrder, Integer.MAX_VALUE, new int[]{0});
	}
    
    public static TreeNode<Integer> build(int[] arr, int n, int[] a){
        if(a[0] == arr.length || arr[a[0]]>n) return null;
        TreeNode<Integer> root = new TreeNode(arr[a[0]++]);
        root.left = build(arr, root.data, a);
        root.right = build(arr, n, a);
        return root;
    }

}
