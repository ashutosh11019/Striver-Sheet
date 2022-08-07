import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
	    // Write your code here.
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(n<3) return ans;
		for(int i=0;i<n-2;i++){
            int low=i+1, high=n-1, sum=K-arr[i];
            while(low<high){
                if(arr[low]+arr[high] == sum){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[low]);
                    temp.add(arr[high]);
                    ans.add(temp);

                    while(low<high && arr[low]==arr[low+1]) low++;
                    while(low<high && arr[high]==arr[high-1]) high--;
                    low++;
                    high--;
                }else if(arr[low]+arr[high] < sum) low++;
                else high--;
            }
            while(i+1<n && arr[i]==arr[i+1]) i++;
		}
		return ans;
	}
}
