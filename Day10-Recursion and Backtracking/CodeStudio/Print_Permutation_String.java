import java.util.*;

public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
		List <String> al = new ArrayList<>();
        permutations(s,al ,"");
        Collections.sort (al);
        return al;
    }
    
    public static void permutations(String str , List<String> al, String asf ){
       if(str.length()==0)
       {   
//            if(!al.contains(asf)) 
               al.add(asf);
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