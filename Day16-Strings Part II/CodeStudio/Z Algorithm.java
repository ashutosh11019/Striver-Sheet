public class Solution {

	public static int zAlgorithm(String s1, String s2, int n, int m) {
		// Write your code here
        int c=0;
		for(int i=0;i<=s1.length()-s2.length();i++){
            String str = s1.substring(i, s2.length()+i);
            if(s2.equals(str)){
                c++;
            }
        }
        return c;
	}

}