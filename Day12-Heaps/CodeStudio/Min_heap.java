import java.util.*;
public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(q[i][0]==0){
                pq.add(q[i][1]);
            }else if(q[i][0]==1){
                arr.add(pq.peek());
                pq.poll();
            }
        }
        int size=arr.size();
        int[] ans = new int[size];
        for(int i=0;i<size;i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}