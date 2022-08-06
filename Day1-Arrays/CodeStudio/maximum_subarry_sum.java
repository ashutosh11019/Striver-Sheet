public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long maxsum = 0L, sum = 0L;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            maxsum=Math.max(maxsum, sum);
            if(sum<0) sum=0L;
        }
        return maxsum;
	}

}