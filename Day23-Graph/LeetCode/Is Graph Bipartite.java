class Solution {
    public boolean dfscheck(int[][] graph, int node, int[] color){
        
        for(int it: graph[node]){
            if(color[it]==-1){
                if(color[node]==0) color[it]=1;
                else color[it]=0;
                if(dfscheck(graph,it,color)==false) return false;
            }else{
                if(color[it]==color[node]) return false;
            }
        }
        // Queue<Integer> q = new LinkedList<>();
        // q.add(node);
        // color[node]=1;
        // while(!q.isEmpty()){
        //     int t = q.poll();
        //     for(int it: graph[t]){
        //         if(color[it]==-1){
        //             color[it]=1-color[t];
        //             q.add(it);
        //         }else if(color[it]==color[t]) return false;
        //     }
        // }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0;i<n;i++) color[i]=-1;
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!dfscheck(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
}