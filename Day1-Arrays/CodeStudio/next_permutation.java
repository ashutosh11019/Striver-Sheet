import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
    {
        // Write your code here.
        int i=permutation.size()-2;
        while(i>=0 && permutation.get(i+1)<=permutation.get(i)) i--;
        if(i>=0){
            int j=permutation.size()-1;
            while(permutation.get(j) <= permutation.get(i)) j--;
            swap(permutation,i,j);
        }
        reverse(permutation,i+1);
        return permutation;
    }
    
    public static void reverse(ArrayList<Integer> permutation, int start){
        int i=start, j=permutation.size()-1;
        while(i<j){
            swap(permutation,i,j);
            i++;
            j--;
        }
    }
    
    public static void swap(ArrayList<Integer> permutation, int i, int j){
        int temp=permutation.get(i);
        permutation.set(i,permutation.get(j));
        permutation.set(j, temp);
    }
}
