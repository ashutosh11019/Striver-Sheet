import java.util.*;
public class Solution {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
		int m = p.length();
        int n = s.length();
        if (n==0) {
           return false;
        }
        int[] lps = kmpProcess(p);
        for (int i = 0, j = 0; i < n;) {
            if (s.charAt(i) == p.charAt(j)) { 
                i++; j++;
            }
            if (j >= m) {
                return true;
            }
            if (i < n && s.charAt(i) != p.charAt(j)) {
                if(j>0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }
    
    static int[] kmpProcess(String pat) {
        int n = pat.length();
        int lps[] = new int[n];
        for (int i = 1, len = 0; i < n;) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len>0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}