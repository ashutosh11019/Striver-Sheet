//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        String str = "";
        List<String> list = new ArrayList<>();
        solve(0, s, str, list);
        Collections.sort(list);
        return list;
    }
    
    static void solve(int i, String s, String str, List<String> list) {
    	if (i == s.length()) {
    		if(str!="") list.add(str);
    		return;
    	}
    	solve(i + 1, s,  str+s.charAt(i), list);
    	solve(i + 1, s,  str, list);
    }
}