// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        ArrayList <String> al = new ArrayList<>();
        permutations(S,al ,"");
        Collections.sort (al);
        return al;
    }
    
    public static void permutations(String str , ArrayList<String> al,String asf ){
       if(str.length()==0)
       {   
           if(!al.contains(asf)) al.add(asf);
           return ;
       }
       for(int i = 0; i < str.length() ; i++)
       {
           char ch = str.charAt(i);
           String s1 = str.substring(0,i);
           String s2 = str.substring(i+1);
           String ros = s1+s2;
           permutations(ros,al,asf + ch);
       } 
   }
}