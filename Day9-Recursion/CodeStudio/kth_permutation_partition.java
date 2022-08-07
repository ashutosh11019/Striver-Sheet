import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
		char[] digits = new char[n];
		for(int i=0;i<n;i++){
			digits[i]=(char)('1'+i);
		}
		int next=1;
		for(int i=2;i<n;i++){
			next*=i;
		}
		k=k-1;
		for(int i=0;i<n-1;i++){
			int dig=(k/next)+i;
			for(int j=dig;j>i;j--){
				char t=digits[j];
				digits[j]=digits[j-1];
				digits[j-1]=t;
			}
			k%=next;
			next/=n-1-i;
		}
		return new String(digits);
    }
}