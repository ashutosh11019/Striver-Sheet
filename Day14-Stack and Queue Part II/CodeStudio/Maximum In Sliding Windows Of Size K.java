
import java.util.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> a, int k) 
	{
		// Write your code here.
		int n = a.size();
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.size(); i++) {
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            while (!q.isEmpty() && a.get(q.peekLast()) < a.get(i)) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a.get(q.peek());
            }
        }
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<r.length;i++){
			arr.add(r[i]);
		}
        return arr;
	}
}