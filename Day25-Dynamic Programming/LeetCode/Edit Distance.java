class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][] = new int[n+1][m+1];
          for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(n,m,word1,word2,dp);
    }
    
    public int f(int i,int j,String word1, String word2,int dp[][] ){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]= f(i-1,j-1,word1,word2,dp);
        
        int insert = 1+f(i,j-1,word1,word2,dp);
        int delete = 1+f(i-1,j,word1,word2,dp);
        int replace = 1 + f(i-1,j-1,word1,word2,dp);
        
        return  dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
}