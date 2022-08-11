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
import java.util.*;

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        path(root,arr1,x);
        path(root,arr2,y);
        int n=arr1.size();
        int m=arr2.size();
        int i=0,j=0;
        int ans=0;
        while(i<n && j<m){
            if(arr1.get(i)==arr2.get(j)){
                ans=arr1.get(i);
            }
            i++;
            j++;
        }
        return ans;
    }
    
    static boolean path(TreeNode<Integer> root, ArrayList<Integer> arr, int n){
        if(root==null) return false;
        arr.add(root.data);
        if(root.data==n) return true;
        if(path(root.left,arr,n) || path(root.right,arr,n)) return true;
        int size = arr.size();
        arr.remove(size-1);
        return false;
    }
}
