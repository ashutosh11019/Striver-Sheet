import java.util.*;
public class Solution {
    public static int chessTournament(int[] positions, int n,  int c){
        // Write your code here.   
        Arrays.sort(positions);
        int l=0;
        int h=positions[n-1]-positions[0];
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(canPlace(mid,c,positions,n)){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
    
    static boolean canPlace(int dist,int c,int[] positions,int n){
        int ninjasplaced=1;
        int recentplacedat=0;
        for(int i=1;i<n;i++){
            if(positions[i]-positions[recentplacedat] >= dist){
                ninjasplaced++;
                recentplacedat=i;
            }
        }
        if(ninjasplaced>=c){
            return true;
        }else{
            return false;
        }
    }
}