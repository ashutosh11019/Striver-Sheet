import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String s) {
        // Write your code here.
		Stack<Character> st = new Stack<>();
		for(char it: s.toCharArray()){
			if(it=='(' || it=='[' || it=='{') st.push(it);
			else{
				if(st.isEmpty()) return false;
				char ch=st.pop();
				if((it==')' && ch=='(') || (it==']' && ch=='[') || (it=='}' && ch=='{')) continue;
				else return false;
			}
		}
		return st.isEmpty();
    }
}