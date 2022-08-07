import java.util.*;
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, new Comparator<Pair>(){
            
            public int compare(Pair a, Pair b){
                double r1 = (double)(a.value) / (double)(a.weight); 
                double r2 = (double)(b.value) / (double)(b.weight); 
                if(r1 < r2) return 1; 
                else if(r1 > r2) return -1; 
                else return 0;
            }
        });
        double ans = 0.0;
        for(int i=0;i<n;i++){
            if(items[i].weight <= w){
                ans+=items[i].value;
                w-=items[i].weight;
            }else{
                ans+=(double)(items[i].value)/items[i].weight * w;
                break;
            }
        }
        return ans;
    }
}
