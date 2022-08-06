public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.     
		long ans = 1L;
		long nn = n;
		long xx = x;
		if(nn < 0) nn = -1*nn;
		while(nn > 0) {
			if(nn%2==1){
				ans = (ans * xx%m)%m;
				nn = nn - 1;
			}else{
				xx = (xx%m*xx%m)%m;
				nn = nn/2;
			}
		}
// 		System.out.println(ans);
		if(n < 0) ans = 1/ans;
		long a = ans%m;
		
		return (int)a;
    }
}