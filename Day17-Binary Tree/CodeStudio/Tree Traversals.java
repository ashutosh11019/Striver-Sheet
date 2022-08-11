/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.*;
class Pair{
    int num;
    BinaryTreeNode<Integer> node;
    Pair(BinaryTreeNode<Integer> node, int num){
        this.node=node;
        this.num=num;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<3;i++) list.add(new ArrayList<>());
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        if(root==null) return list;
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.num == 1){
                list.get(1).add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left != null) st.push(new Pair(it.node.left, 1));
            }else if(it.num==2){
                list.get(0).add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.right != null) st.push(new Pair(it.node.right, 1));
            }else{
                list.get(2).add(it.node.data);
            }
        }
        return list;
    }
}
