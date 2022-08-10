import java.util.*;
public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
        String[] words = str.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
	}
}
