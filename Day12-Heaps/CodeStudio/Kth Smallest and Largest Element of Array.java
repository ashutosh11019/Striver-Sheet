import java.util.*;
public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for(int i=0;i<arr.size();i++){
            pq1.add(arr.get(i));
        }
        for(int i=0;i<k-1;i++){
            pq1.poll();
        }
        ans.add(pq1.poll());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr.get(i));
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        ans.add(pq.poll());
        
        
        
        return ans;
	}
}
