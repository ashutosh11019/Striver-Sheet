/*
    Time Complexity: O(N*(2^N))
    Space Complexity: O(N*(2^N))

    Where N is the number of elements in array
*/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) 
    {    
        int n = arr.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {    
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) 
            {
                if ((i & (1 << j)) > 0) 
                {
                    temp.add(arr.get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

