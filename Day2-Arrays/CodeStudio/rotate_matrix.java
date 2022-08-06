import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
		int r=0, c=0, prev, cur;
        while(r<n && c<m){
            if(r+1==n || c+1==m) break;
            prev=mat.get(r+1).get(c);
            for(int i=c;i<m;i++){
                cur=mat.get(r).get(i);
                mat.get(r).set(i,prev);
                prev=cur;
            }
            r++;
            for(int i=r;i<n;i++){
                cur=mat.get(i).get(m-1);
                mat.get(i).set(m-1,prev);
                prev=cur;
            }
            m--;
            if (r < n){
               for (int i=m-1;i>=c;i--){
                   cur = mat.get(n-1).get(i);
                   mat.get(n-1).set(i,prev);
                   prev = cur;
               }
           }
           n--;
           if (c < m){
               for (int i=n-1;i>=r;i--){
                   cur = mat.get(i).get(c);
                   mat.get(i).set(c,prev);
                   prev = cur;
               }
           }
           c++;
        }
    }
}
