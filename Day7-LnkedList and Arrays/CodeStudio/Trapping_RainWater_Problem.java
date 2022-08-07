import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.
		long res = 0L;
		int left=0, right=n-1;
		long maxleft = 0L, maxright= 0L;
		
		while(left<=right){
			if(arr[left] <= arr[right]){
				if(arr[left] >= maxleft){
					maxleft = arr[left];
				}else{
					res+=maxleft-arr[left];
				}
				left++;
			}else{
				if(arr[right] >= maxright){
					maxright = arr[right];
				}else{
					res+=maxright-arr[right];
				}
				right--;
			}
		}
		return res;
    }
}
