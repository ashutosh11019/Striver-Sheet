import javafx.util.Pair;
import java.util.*;
public class Solution {

	public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
		// Write your code here
		long len = arr.size();
		long S = (len * (len+1) ) /2;
		long P = (len * (len +1) *(2*len +1) )/6;
		long missingNumber=0, repeating=0;

		for(int i=0;i<arr.size(); i++){
		   S -= (long)arr.get(i);
		   P -= (long)arr.get(i)*(long)arr.get(i);
		}

		missingNumber = (S + P/S)/2;
		repeating = missingNumber - S;

		return new Pair(missingNumber, repeating);

	}
}