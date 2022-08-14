import java.util.*;
public class Solution {
    public static int cutLogs(int k, int n) {
        //Write your code here
        int[][] dp = new int[n+1][k+1];
        int m = 0;
        while (dp[m][k] < n) {
            m++;
            for (int i = 1; i <= k; ++i)
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
        }
        return m;
    }
}
