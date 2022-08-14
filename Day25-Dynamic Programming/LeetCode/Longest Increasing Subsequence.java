class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];   
        dp[0] = nums[0];
        int res = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>dp[res-1]){
                dp[res] = nums[i];
                res++;
            }else{
                for(int j=0;j<i;j++){
                    if(dp[j]>=nums[i]){
                        dp[j] = nums[i];
                        break;
                    }
                }
            }
            
        }
        
        return res;
    }
}