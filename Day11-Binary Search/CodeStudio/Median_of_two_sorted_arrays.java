public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
		int m=a.length, n=b.length;
		if(m>n) return median(b,a);
		int low=0, high=m, medianPos=((m+n)+1)/2;
		while(low<=high){
			int cut1=(low+high)>>1;
			int cut2=medianPos-cut1;
			int l1=(cut1==0)?Integer.MIN_VALUE:a[cut1-1];
			int l2=(cut2==0)?Integer.MIN_VALUE:b[cut2-1];
			int r1=(cut1==m)?Integer.MAX_VALUE:a[cut1];
			int r2=(cut2==n)?Integer.MAX_VALUE:b[cut2];
			if(l1<=r2 && l2<=r1){
				if((m+n)%2 != 0) return Math.max(l1,l2);
				else return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
			}else if(l1>r2) high=cut1-1;
			else low=cut1+1;
		}
		return 0.0;
    }
}