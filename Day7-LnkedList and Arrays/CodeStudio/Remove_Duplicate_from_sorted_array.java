import java.util.ArrayList;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
		int i=0;
		for(int j=0;j<n;j++){
			if(arr.get(i) != arr.get(j)){
				i++;
				arr.set(i,arr.get(j));
			}
		}
		
// 		int c=0;
// 		for(int j=0;j<n;j++){
// 			if(arr.get(j) >= arr.get(j+1)) break;
// 			else c++;
// 		}
		return i+1;
	}
}