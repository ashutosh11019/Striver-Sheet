import java.util.*;

public class Solution {
//     public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, int[] vis){
//         vis[node]=1;
//         for(int it: adj.get(node)){
//             if(vis[it]==0) dfs(adj, it, st, vis);
//         }
//         st.add(node);
//     }
    
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        
        //BFS
//         int topo[] = new int[v];
        ArrayList<Integer> topo = new ArrayList<>();
        int indegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)) indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int node =q.poll();
//             topo[c++]=node;
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return topo;
        
        //DFS
//         Stack<Integer> st = new Stack<>();
//         int vis[] = new int[v];
//         for(int i=0;i<v;i++){
//             if(vis[i]==0) dfs(adj, i, st, vis);
//         }
// //         int topo[] = new int[v];
//         ArrayList<Integer> topo = new ArrayList<>();
//         int c=0;
//         while(!st.isEmpty()){
// //             topo[c++]=st.pop();
//             topo.add(st.pop());
//         }
//         return topo;
    }
}
