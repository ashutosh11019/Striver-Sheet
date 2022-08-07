import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        // Write your code here.
		ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        findCombinations(0, arr, k, ans, new ArrayList < > ());
        return ans;
    }
	
	private static void findCombinations(int ind, ArrayList<Integer> arr, int target, ArrayList < ArrayList < Integer >> ans, ArrayList < Integer > ds) {
        if (ind == arr.size()) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr.get(ind) <= target) {
            ds.add(arr.get(ind));
            findCombinations(ind, arr, target - arr.get(ind), ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
}