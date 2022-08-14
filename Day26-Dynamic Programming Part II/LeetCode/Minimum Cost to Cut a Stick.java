class Solution {
    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        int[] cost = new int[cuts.length+2];
        cost[0] = 0;
        cost[cost.length-1] = n;
        
        for(int i=1; i<=cuts.length; i++) cost[i] = cuts[i-1];
        Arrays.sort(cost);
        
        for(int i = cost.length; i>0;i--){
            for(int j = i; j<cost.length-1; j++){
                
                int min = (int)Math.pow(10,9);
                for(int k = i; k<=j; k++){
                    int costx = cost[j+1]-cost[i-1] + dp[i][k-1]+dp[k+1][j];
                    min = Math.min(costx,min);
                }
                dp[i][j]=min;
            }
        }
        
        return dp[1][cuts.length];

        // Arrays.sort(cuts);
        // int[] helper=new int[cuts.length+2];
        // helper[0]=0;
        // for(int i=0;i<cuts.length;i++){
        //   helper[i+1]=cuts[i];
        // }
        // helper[helper.length-1]=n;
        // int[][] min=new int[helper.length][helper.length];
        // for(int i=1;i<helper.length;i++){
        //   for(int j=i-1;j>=0;j--){
        //     if(j==i-1){
        //       min[j][i]=0;
        //     }else{
        //       min[j][i]=Integer.MAX_VALUE;
        //       for(int k=j+1;k<=i-1;k++){
        //         min[j][i]=Math.min(min[j][i],min[j][k]+min[k][i]);
        //       }
        //       min[j][i]+=helper[i]-helper[j];
        //     }

        //   }
        // }
        // return min[0][helper.length-1];
    }
}