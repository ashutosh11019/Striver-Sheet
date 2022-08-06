import java.util.*;
public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
		int max=0,sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum,-1);
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(map.containsKey(sum)==false){
                map.put(sum,i);
            }else{
                max=Math.max(max,i-map.get(sum));
            }
        }
        return max;
	}
}