import java.util.*;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
        int ans = arr.get(0);
        int max = arr.get(0);
        int min = arr.get(0);
        
        for(int i=1;i<n;i++){
            if(arr.get(i)<0){
                int temp=min;
                min=max;
                max=temp;
            }
            max=Math.max(arr.get(i),arr.get(i)*max);
            min=Math.min(arr.get(i),arr.get(i)*min);
            ans=Math.max(ans,max);
        }
        return ans;
	}
}