
public class Solution {

    public static int minCharsforPalindrome(String str) {
        //Write your code here
        StringBuilder s = new StringBuilder();
        s.append(str);
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);
        int lps[] = LPS(s.toString());
        return str.length() - lps[s.length() - 1];
    }
    
    public static int[] LPS(String str) {
        int n = str.length();
        int lps[] = new int[n];
        int i = 1, len = 0;
        lps[0] = 0;
        
        while (i < n)
        {
            if (str.charAt(i) == str.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}