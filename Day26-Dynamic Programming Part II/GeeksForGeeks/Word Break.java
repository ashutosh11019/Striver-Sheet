// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        int n=A.length();
        boolean[] dp = new boolean[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=B.contains(A.substring(i,n));
            for(int j=i+1;j<=n-1;j++){
                dp[i]=dp[i] | (B.contains(A.substring(i,j))==true && dp[j]==true);
            }
        }
        if(dp[0]==true) return 1;
        return 0;
    }
}