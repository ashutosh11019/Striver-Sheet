import java.util.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
        ArrayList<String> ans = new ArrayList<>();
        String cur = "";
        words(s, 0, dictionary, ans, cur);
        return ans;
	}
    
    public static void words(String s, int start, ArrayList<String> dictionary, ArrayList<String> ans, String cur){
        if(start >= s.length()) {
            ans.add(cur);
            return;
        }

        for(int i=start; i<s.length(); i++) {
            String temp = s.substring(start, i+1);

            boolean isPresent = false;
            for(String st : dictionary) {
                if(st.equals(temp) == true) {
                    isPresent = true;
                    break;
                }
            }

            if(isPresent) {
                String x = cur;
                cur += temp + " ";

                words(s, i+1, dictionary, ans, cur);
                cur = x;
            }
        }
    }
}