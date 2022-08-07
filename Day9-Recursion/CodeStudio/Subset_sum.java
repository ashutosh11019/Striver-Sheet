import java.util.*;

public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList < Integer > sumSubset = new ArrayList < > ();
        func(0, 0, num, num.length, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    
    static void func(int ind, int sum, int[] arr, int N, ArrayList < Integer > sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }
        func(ind + 1, sum + arr[ind], arr, N, sumSubset);
        func(ind + 1, sum, arr, N, sumSubset);
    }
}