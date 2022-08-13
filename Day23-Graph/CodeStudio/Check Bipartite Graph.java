import java.util.*;

public class Solution {
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int node, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int it: adj.get(n)){
                if(color[it]==-1){
                    color[it]=1-color[n];
                    q.add(it);
                }else if(color[it]==color[n]) return false;
            }
        }
        return true;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] color){
        if(color[node]==-1) color[node]=1;
        for(int it: adj.get(node)){
            if(color[it]==-1){
                color[it]=1-color[node];
                if(!dfs(adj, it, color)) return false;
            }else if(color[it]==color[node]) return false;
        }
        return true;
    }
    
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.size();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edges.get(i).get(j)==1) adj.get(i).add(j);
            }
        }
//         System.out.println(adj);
        
        
        
        int color[] = new int[n];
        for(int i=0;i<n;i++) color[i]=-1;
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                //if(!dfs(adj, i, color)) return false; //DFS
                if(!bfs(adj, i, color)) return false; //BFS
            }
        }
        return true;
    }
}