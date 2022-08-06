import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		ArrayList<ArrayList<Long>> arr = new ArrayList<>();
		ArrayList<Long> pre = null;
		for(int i=0;i<n;i++){
			ArrayList<Long> list = new ArrayList<>();
			for(int j=0;j<=i;j++){
				if(j==0 || j==i) list.add(1L);
				else list.add(pre.get(j-1)+pre.get(j));
			}
			pre = list;
			arr.add(list);
		}
		return arr;
	}
}