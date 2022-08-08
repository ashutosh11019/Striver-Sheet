import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix.get(0).size();j++)
            {
                ans.add(matrix.get(i).get(j));
            }
        }

        Collections.sort(ans);
        int m=ans.size()/2;
        int x=ans.get(m);
        return x;
	}
}