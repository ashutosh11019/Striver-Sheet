public class Solution {	
	public static String longestPalinSubstring(String s) {
		// Write your code here.
        if (s.length()==0) return "";
        if (s.length() == 1) return s;
        int min_start = 0, max_len = 1;
        for (int i = 0; i < s.length();) {
            if (s.length() - i <= max_len / 2) break;
            int j = i, k = i;
            while (k < s.length()-1 && s.charAt(k+1) == s.charAt(k)) ++k;
            i = k+1;
            while (k < s.length()-1 && j > 0 && s.charAt(k+1) == s.charAt(j-1)) { 
                ++k; 
                --j; 
            }
            int new_len = k - j + 1;
            if (new_len > max_len) { 
                min_start = j; 
                max_len = new_len; 
            }
        }
        return s.substring(min_start, min_start+max_len);
	}
}
