import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
		int buy=Integer.MAX_VALUE,sell=0;
        for(int i=0;i<prices.size();i++){
            buy=Math.min(buy,prices.get(i));
            sell=Math.max(sell,prices.get(i)-buy);
        }
       return sell;
    }
}