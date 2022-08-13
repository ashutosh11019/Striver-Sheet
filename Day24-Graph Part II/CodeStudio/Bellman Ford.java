import java.util.*;
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      // Write your code here.
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<=n;i++){
            visited[i]=false;
        }
        int[] distance = new int[n+1];
        for(int i=0;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<m;j++){
                int u=edges.get(j).get(0);
                int v=edges.get(j).get(1);
                int w=edges.get(j).get(2);
                if(distance[u]!=Integer.MAX_VALUE && distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                }

            }
        }
        if(distance[dest]==Integer.MAX_VALUE){
            return 1000000000;
        }
        return distance[dest];
    }
    
}
