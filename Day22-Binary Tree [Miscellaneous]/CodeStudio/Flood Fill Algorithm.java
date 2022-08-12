import java.util.*;
public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int color = image[x][y];
        if (color != newColor) dfs(image, x, y, color, newColor);
        return image;
    }
    
    public static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}

