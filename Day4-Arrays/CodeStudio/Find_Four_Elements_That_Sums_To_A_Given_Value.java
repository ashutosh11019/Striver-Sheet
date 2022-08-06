import java.util.* ;
import java.io.*; 
class Pair
{
    public int x, y;
 
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
  public static String fourSum(int[] nums, int target, int n) {
      // Write your code here.
     Map<Integer, List<Pair>> map = new HashMap<>();
     for (int i = 0; i < n - 1; i++)
     {
            for (int j = i + 1; j < n; j++)
            {
                int val = target - (nums[i] + nums[j]);
                if (map.containsKey(val))
                {
                    for (Pair pair: map.get(val))
                    {
                        int x = pair.x;
                        int y = pair.y;
                        if ((x != i && x != j) && (y != i && y != j))
                        {
//                             System.out.println("Quadruplet Found ("
//                                         + nums[i] + ", " + nums[j] + ", "
//                                         + nums[x] + ", " + nums[y] + ")");
                            return "Yes";
                        }
                    }
                }
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(new Pair(i, j));
            }
        }
 
        // return false if quadruplet doesn't exist
        return "No";
  }
}
