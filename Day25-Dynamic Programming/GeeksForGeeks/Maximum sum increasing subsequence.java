//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[] = new int[n];
	    int ans = 0;
	    for(int i=0;i<n;i++){
	        int sum=0;
	        for(int j=i-1;j>=0;j--){
	            if(arr[j]<arr[i]) sum=Math.max(sum, dp[j]);
	        }
	        dp[i]=sum+arr[i];
	        ans=Math.max(ans, dp[i]);
	    }
	    return ans;
	}  
}