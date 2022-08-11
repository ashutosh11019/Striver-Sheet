/*
    Time complexity: O( max(M, N) ) 
    Space complexity: O( max(M, N) )
    
    M and N are number of nodes in binary tree 1 and binary tree 2 respectively.
*/
    
import java.util.*;

public class Solution {
    
    public static ArrayList<Integer> createLevelOrder(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList();
        
        if(root == null) {
            res.add(-1);
            return res;
        }
        

        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
        
        q.add(root);
        res.add(root.data);
        
        while(!q.isEmpty()) {
            
            BinaryTreeNode<Integer> first = q.poll();
            
 
            if(first.left != null) {
                q.add(first.left);
                res.add(first.left.data);
            }
            else {
                res.add(-1);
            }
            

            if(first.right != null) {
                q.add(first.right);
                res.add(first.right.data);
            }
            else {

                res.add(-1);
            }

        }
        
        return res;

    }

    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        
     
        ArrayList<Integer> arr1 = createLevelOrder(root1);
        

        ArrayList<Integer> arr2 = createLevelOrder(root2);
        
        if(arr1.size() != arr2.size()) {
            return false;
        }
        

        for(int i = 0; i < arr1.size(); i++) {
            if(!arr1.get(i).equals(arr2.get(i))) {
                return false;
            }
        }
        
        return true;
            
    }

}