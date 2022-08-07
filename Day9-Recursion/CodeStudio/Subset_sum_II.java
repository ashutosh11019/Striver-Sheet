import java.util.*;
public class Solution {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int nums[]) {
        // Write your code here..
		Arrays.sort(nums); 
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>(); 
        findSubsets(0, nums, new ArrayList<>(), ansList); 
        return ansList;
    }
	
	public static void findSubsets(int ind, int[] nums, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds)); 
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ansList); 
            ds.remove(ds.size() - 1);
        }
        
    }

}