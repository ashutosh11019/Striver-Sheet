import java.util.*;
public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<Integer> v = new ArrayList<>();
        for(int i =0;i<queries.size();i++){
            int xo = queries.get(i).get(0);
            int limit = queries.get(i).get(1);
            int maxi =-1;
            for(int j =0;j<arr.size();j++){
                if(arr.get(j)>limit){
                    break;
                }else{
                    int res = xo^arr.get(j);
                    maxi=Math.max(maxi,res);
                }
            }
            v.add(maxi);
        }
        return v;
    }
}