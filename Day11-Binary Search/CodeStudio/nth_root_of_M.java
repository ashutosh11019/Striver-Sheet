import java.util.*;
public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
		double t=1.000000/n;
        double ans=Math.pow(m,t);
        return ans;
    }
}