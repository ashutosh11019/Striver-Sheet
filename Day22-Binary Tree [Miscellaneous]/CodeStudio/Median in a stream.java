/*

    Time complexity: O(N*(log(N))) 
    Space complexity: O(N)
    
    where N is the total number of elements in the array.

*/

import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int[] medians = new int[n];
        PriorityQueue<Integer> lo = new PriorityQueue<>();
        PriorityQueue<Integer> hi = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            lo.add(num);
            hi.add(lo.poll());
            if (lo.size() < hi.size()) {
                lo.add(hi.poll());

            }
            int median;
            if (lo.size() > hi.size()) {
                median = lo.peek();
            }else {
                median = (lo.peek() + hi.peek()) / 2;
            }
            medians[i] = median;
        }
        return medians;
    }
}
