import java.util.*;

class Sortbyroll implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.get(2) < b.get(2)) return -1;
        else return 1;
    }
}

public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.
        Collections.sort(graph, new Sortbyroll());
        int cost = 0;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1;i<par.length;++i) par[i] = i;

        for(ArrayList<Integer> i:graph){
            if(findPar(i.get(0), par)!=findPar(i.get(1), par)){
                cost+=i.get(2);
                union_(findPar(i.get(0),par),findPar(i.get(1),par),rank,par);
            }
        }

        return cost;
    }
    
    static int findPar(int u,int[] par){
        if(u == par[u]){
            return u;
        }
        return par[u] = findPar(par[u],par);
    }
    
    static void union_(int u, int v, int[] rank,int[] par){
        if(rank[u]<rank[v]){
            par[u] = v;
        }else if(rank[v]<rank[u]){
            par[v] = u;
        }else{
            par[v] = u;
            rank[u]++;
        }
    }
    
    
}