import java.util.*;
public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n+1][value+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=value;j++){
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=value;j++){
                if(denominations[i-1]<=j) dp[i][j]=dp[i-1][j]+dp[i][j-denominations[i-1]];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][value];
	}
}