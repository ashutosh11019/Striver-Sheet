import java.util.*;
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		//write your code here
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < input.length()) {
			if (!set.contains(input.charAt(j))) {
				set.add(input.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(input.charAt(i++));
			}
		}

		return max;
	}
}
