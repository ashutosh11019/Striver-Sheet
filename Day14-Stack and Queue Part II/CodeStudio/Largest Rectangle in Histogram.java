import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.
      Stack < Integer > st = new Stack < > ();
      int max = 0;
      int n = heights.size();
      for (int i = 0; i <= n; i++) {
          while (!st.empty() && (i == n || heights.get(st.peek()) >= heights.get(i))) {
              int height = heights.get(st.peek());
              st.pop();
              int width;
              if (st.empty())
                  width = i;
              else
                  width = i - st.peek() - 1;
              max = Math.max(max, width * height);
          }
          st.push(i);
      }
      return max;
  }
}