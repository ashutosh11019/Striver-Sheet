import java.util.*;
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        // Write your code here. 
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			int sum = s - arr[i];
			if(map.containsKey(sum)){
				int n = map.get(sum);
				while(n-->0){
					list.add(sum);
					list.add(arr[i]);
				}
			}
			if(map.containsKey(arr[i])){
				int n = map.get(arr[i])+1;
				map.put(arr[i],n);
			}else
				map.put(arr[i],1);
		}
		int[][] res = new int[list.size()/2][2];
		int j=0;
		for(int i=0;i<list.size();i=i+2){
			int a =list.get(i),b=list.get(i+1);
			if(a<b){
				res[j][0]=list.get(i);
				res[j][1]=list.get(i+1);
			}else{
				res[j][0]=list.get(i+1);
				res[j][1]=list.get(i);
			}
			j++;
		}
		Arrays.sort(res,(a,b)->a[0]-b[0]);
		return res;
    }
}