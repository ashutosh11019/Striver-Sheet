import java.util.*;

public class Solution {
//     public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int[] dfsvis){
//         vis[node]=1;
//         dfsvis[node]=1;
//         for(int it: adj.get(node)){
//             if(vis[it]==0){
//                 if(dfs(adj, it, vis, dfsvis)==true) return true;
//             }else if(dfsvis[it]==1) return true;
//         }
//         dfsvis[node]=0;
//         return false;
//     }
    
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            //           adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        int[] topo = new int[n+1];
        int[] indegree = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int node = q.poll();
            c++;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(c==n) return false;
        else return true;
        
        // DFS Approach
//         int vis[] = new int[n+1];
//         int dfsvis[] = new int[n+1];
//         for(int i=1;i<=n;i++){
//             if(vis[i]==0){
//                 if(dfs(adj, i, vis, dfsvis)==true) return true;
//             }
//         }
//         return false;
    }
}