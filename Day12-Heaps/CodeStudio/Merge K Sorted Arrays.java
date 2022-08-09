import java.util.*;
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for(int i=0; i<k ; i++){
            for(int j=0; j< kArrays.get(i).size(); j++){
                minh.add(kArrays.get(i).get(j));
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(minh.size() > 0) {
            res.add(minh.peek());
            minh.poll();
        }  
        return res;
	}
}
