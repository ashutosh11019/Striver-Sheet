import java.util.ArrayList;

public class Solution {
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
		// Write your code here.
        int index = -1;
        for(int i=0;i<m;i++){
            if(mat.get(i).get(n-1)>=target){
                index = i;
                break;
            }
        }
        if(index == -1) return false;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat.get(index).get(mid) == target) return true;
            else if(mat.get(index).get(mid) > target) high=mid-1;
            else if(mat.get(index).get(mid) < target) low=mid+1;
        }
        return false;
	}
}
