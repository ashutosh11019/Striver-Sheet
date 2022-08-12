import java.util.*;
public class Solution {
	static int kthLargest(ArrayList<Integer> nums, int size, int k) {
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<size;i++){
            pq.add(nums.get(i));
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();
	}
}
