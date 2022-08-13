import java.util.*;
class Node{
    int first, second;
    Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Solution {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int[] vis){
        vis[node]=1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfs(adj, it, node, vis)==true) return true;
            }else if(it != parent) return true;
        }
        return false;
    }
    
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1));
        vis[i]=1;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int prev = q.peek().second;
            q.poll();
            for(int it: adj.get(node)){
                if(vis[it]==0){
                    q.add(new Node(it, node));
                    vis[it]=1;
                }else if(prev != it) return true;
            }
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int vis[] = new int[n+1];
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
//                 if(bfs(adj, i, vis)==true) return "Yes";
                if(dfs(adj, i, -1, vis)==true) return "Yes";
            }
        }
        return "No";
    }
    
}