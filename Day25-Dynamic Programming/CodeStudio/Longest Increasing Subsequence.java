import java.util.*;
public class Solution {
	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        int n = arr.length;
        int dp[] = new int[n];   
        dp[0] = arr[0];
        int res = 1;
        for(int i=1;i<n;i++){
            if(arr[i]>dp[res-1]){
                dp[res] = arr[i];
                res++;
            }else{
                for(int j=0;j<i;j++){
                    if(dp[j]>=arr[i]){
                        dp[j] = arr[i];
                        break;
                    }
                }
            }
            
        }
        
        return res;
	}
}