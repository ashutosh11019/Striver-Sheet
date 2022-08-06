public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		int count = 0;
        int res = -1;

        for (int num : arr) {
            if (count == 0) {
                res = num;
            }
            if(num==res) count += 1; 
            else count -= 1; 
        }
		int c = 0;
		for(int num: arr){
			if(num == res) c++;
		}
		if(c > (n/2)) return res;
		return -1;
	}
}