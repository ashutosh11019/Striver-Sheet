import java.util.*;
public class Solution {
    public static Boolean wordBreak(String[] arr, int N, String target) {
        // Write your code here.
        ArrayList<String> list = new ArrayList<>();
        for(String str: arr) list.add(str);
        int n=target.length();
        boolean[] dp = new boolean[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=list.contains(target.substring(i,n));
            for(int j=i+1;j<=n-1;j++){
                dp[i]=dp[i] | (list.contains(target.substring(i,j))==true && dp[j]==true);
            }
        }
        if(dp[0]==true) return true;
        return false;
    }
}