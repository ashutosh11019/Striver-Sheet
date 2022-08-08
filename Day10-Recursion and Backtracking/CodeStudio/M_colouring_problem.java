public class Solution {
	public static String graphColoring(int[][] mat, int m) {
		// Write your code here
        int n=mat.length;
        int[] color = new int[n];
        if(solve(mat,color,n,m,0)) 
            return "YES";
        return "NO";
	}
    
    public static boolean solve(int[][] mat,int[] color, int n,int m,int node) {
        if(node==n) 
            return true;
        for(int i=1;i<=m;i++)
        {
           if(ispossible(mat,color,node,i,n))
           {
               color[node]=i;
               if(solve(mat,color,n,m,node+1))
                   return true;
               color[node]=0;
           }
        }    
        return false;    
    }
    
    public static boolean ispossible(int[][] mat,int[] color,int node,int col,int n){
        for(int i=0;i<n;i++){
            if(node!=i && mat[node][i]==1 && color[i]==col)
                return false;
        }
        return true;
    }
}
