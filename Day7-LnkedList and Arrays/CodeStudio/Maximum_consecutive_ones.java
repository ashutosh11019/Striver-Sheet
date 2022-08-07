import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
        int length = 0;

        int zerosCount = 0;

        int start = 0;
        for (int end = 0; end < n; end++) {

            if (arr.get(end) == 0) zerosCount += 1;

            if (zerosCount > k && start <= end) {
                if (arr.get(start) == 0) zerosCount -= 1;
                start += 1;
            }
            length = Math.max(length, end - start + 1);
        }
        return length;
	}
}