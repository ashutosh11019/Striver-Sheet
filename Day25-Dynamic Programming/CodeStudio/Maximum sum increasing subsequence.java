import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        int dp[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i-1;j>=0;j--){
                if(rack.get(j)<rack.get(i)) sum=Math.max(sum, dp[j]);
            }
            dp[i]=sum+rack.get(i);
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }
}