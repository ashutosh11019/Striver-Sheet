import java.util.*;
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
		int c = 0;
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0;i<N;i++){
			hs.add(arr[i]);
		}
		for(int num: arr){
			if(!hs.contains(num-1)){
				int cur = num;
				int count = 1;
				while(hs.contains(cur+1)){
					cur++;
					count++;
				}
				c = Math.max(c,count);
			}
		}
		return c;
    }
}