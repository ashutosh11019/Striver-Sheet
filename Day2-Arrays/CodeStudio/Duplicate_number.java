import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
		int l = arr.size();
		for(int num: arr){
			int i = Math.abs(num);
			if(arr.get(i)<0) return i;
			arr.set(i,-arr.get(i));
		}
		return l;
    }
}
