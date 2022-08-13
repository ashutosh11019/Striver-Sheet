import java.util.*;
class Pair{
    int first, second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.
        Map<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for(int i=0; i<g.size(); i++) {
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);
            
            if(!adj.containsKey(u)){
                ArrayList<Pair> cur = new ArrayList<>();
                cur.add(new Pair(v,w));
                adj.put(u, cur);
            }else{
                adj.get(u).add(new Pair(v, w));
            }
            
            if(!adj.containsKey(v)){
                ArrayList<Pair> cur = new ArrayList<>();
                cur.add(new Pair(u,w));
                adj.put(v, cur);
            }else{
                adj.get(v).add(new Pair(u, w));
            }
        }

        int[] key = new int[n+1];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mst = new boolean[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        key[1] = 0;
        parent[1] = -1;

        for(int i=1; i<n; i++) {
            int mini = Integer.MAX_VALUE;
            int u=0;
            for(int v=1; v<=n; v++) {
                if(!mst[v] && key[v] < mini) {
                    u = v;
                    mini = key[v]; 
                } 
            }
            mst[u] = true;
            for(Pair it : adj.get(u)) {
                int v = it.first;
                int w = it.second;
                if(!mst[v] && w < key[v]) {
                    key[v] = w;
                    parent[v] = u;
                }
            }
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for(int i=2; i<=n; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(parent[i]);
            sub.add(i);
            sub.add(key[i]);
            answer.add(sub);      
        }

        return answer;
    }
}
