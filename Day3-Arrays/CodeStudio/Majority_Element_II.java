import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
		if(arr.size() == 0) return new ArrayList<Integer>();
		int n1 = arr.get(0), n2 = arr.get(0), c1 = 0, c2 = 0;
		for(int i=0;i<arr.size();i++){
			if(arr.get(i) == n1) c1++;
			else if(arr.get(i) == n2) c2++;
			else if(c1 == 0){
				n1 = arr.get(i);
				c1 = 1;
			}else if(c2 == 0){
				n2 = arr.get(i);
				c2 = 1;
			}else{
				c1--;
				c2--;
			}
		}
		c1 = 0;
		c2 = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0;i<arr.size();i++){
			if(arr.get(i) == n1) c1++;
			else if(arr.get(i) == n2) c2++;
		}
		int len = arr.size();
		if(c1 > len/3) res.add(n1);
		if(c2 > len/3) res.add(n2);
		return res;
    }
}