import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        int[][] ans = new int[n][n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(maze,0,0,ans,n,res);
        return res;
    }
    
    static void dfs(int[][] maze, int i, int j, int[][] ans, int n, ArrayList<ArrayList<Integer>> res){
       if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || ans[i][j]==1)
           return;
       if(i==n-1 && j==n-1 && maze[i][j]==1){
           ArrayList<Integer> path = new ArrayList<>();
           ans[i][j]=1;
           for(int x=0;x<n;x++){
               for(int y=0;y<n;y++){
                   path.add(ans[x][y]);
               }
           }
           res.add(path);
       }

       ans[i][j]=1;
       dfs(maze,i+1,j,ans,n,res);
       dfs(maze,i-1,j,ans,n,res);
       dfs(maze,i,j+1,ans,n,res);
       dfs(maze,i,j-1,ans,n,res);
       ans[i][j]=0;
    }
}