public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size()<B){
            return -1;
        }
        int sum = 0, ans = -1;
        for(int i = 0;i<A.size();i++){
            sum+=A.get(i);
        }
        int low = 0, high = sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(good(A, B, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    static boolean good(ArrayList<Integer> A, int m, int mid){
        if(A.get(0)>mid){
            return false;
        }
        int n = A.size();
        int cnt = 1, s = A.get(0);
        for(int i = 1;i<n;i++){
            if(A.get(i)>mid){
                return false;
            }
            if((A.get(i)+s)<=mid){
                s+=A.get(i);
            }
            else{
                s = A.get(i);
                cnt++;
            }
        }
        if(cnt>m){
            return false;
        }
        return true;
    }
}
