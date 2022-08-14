class Solution {
    public boolean canPartition(int[] nums) {
        int subsetSum = 0;
        for(int i=0; i< nums.length; i++){
            subsetSum+= nums[i];
        }
        if(subsetSum %2 !=0 ) return false;
        subsetSum/=2;
        boolean[]dp = new boolean[subsetSum+1];
        dp[0] = true;
        for(int i=1; i<= nums.length; i++){
            int curr = nums[i-1];
            for(int j=subsetSum; j>= curr; j--){
                dp[j] |=  dp[j-curr];
            }
        }
        return dp[subsetSum];
    }
}