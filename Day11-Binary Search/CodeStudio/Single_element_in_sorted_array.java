import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
		int ans = 0;
		for(int num: arr){
			ans = ans^num;
		}
		return ans;
    }
}