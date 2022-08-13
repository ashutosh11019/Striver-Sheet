import java.util.*;

public class Solution {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[][] adj = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(adj[i], 1000000000);
    
        for(ArrayList<Integer> x : edges)
        {
            adj[x.get(0)][x.get(1)] = x.get(2); 
        }

        int n1 = n+1;
        while(n1-->0)
        {
           adj[n1][n1] = 0;
        }
        for(int k=1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if((adj[i][k]!=1e9 && adj[k][j]!=1e9) && (adj[i][k]+adj[k][j]<adj[i][j])){
                        adj[i][j]=adj[i][k]+adj[k][j];
                    }
                }
            }
        }

        return adj[src][dest];
    }

}
