import java.util.*;

public class Solution {
    private static void dfsFill(int[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1){
            grid[i][j]=0;
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
            
            dfsFill(grid, i-1, j-1);
            dfsFill(grid, i+1, j+1);
            dfsFill(grid, i-1, j+1);
            dfsFill(grid, i+1, j-1);
        }
    }
    
    public static int getTotalIslands(int[][] mat) {
        //Your code goes here
        int c=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    dfsFill(mat,i,j);
                    c++;
                }
            }
        }
        return c;
    }
}