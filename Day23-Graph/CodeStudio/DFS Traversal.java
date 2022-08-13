import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] c = new int[v];

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<e;i++){
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            
            if(!map.containsKey(a)){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(b);
                map.put(a, arr);
            }else{
                map.get(a).add(b);
                //map.put(a, map.get(a).add(b));
            }
            
            if(!map.containsKey(b)){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(a);
                map.put(b, arr);
            }else{
                map.get(b).add(a);
                //map.put(a, map.get(b).add(a));
            }
//             ArrayList<Integer> arr1 = con.get(a);
         
//             ArrayList<Integer> arr2 = con.get(b);
        }

        for(int i=0;i<v;i++){
            if(c[i] == 0){
                ArrayList<Integer> t = new ArrayList<>();
                adder(t,v,e,i,map,c);
                Collections.sort(t);
                ans.add(t);
            }
        }
        return ans;
    }
    
    static void adder(ArrayList<Integer> t, int v, int e, int x, Map<Integer,ArrayList<Integer>> map, int[] c){
        c[x] = 1;
        t.add(x);
        if(!map.containsKey(x)) return;
        for(int i=0;i<map.get(x).size();i++){
            if(c[map.get(x).get(i)]==0){
                adder(t,v,e,map.get(x).get(i),map,c);
            }
        }
        return;
    }
}