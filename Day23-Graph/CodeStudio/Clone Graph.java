/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
import java.util.*;

public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        // Write your code here.
        if(node == null) return null;
        graphNode copy = new graphNode(node.data);
        graphNode[] visited = new graphNode[101];
        Arrays.fill(visited , null);
        dfs(node , copy , visited);
        return copy;
    }
    
    public static void dfs(graphNode node , graphNode copy , graphNode[] visited){
        visited[copy.data] = copy;
        for(graphNode n : node.neighbours){
            if(visited[n.data] == null){
                graphNode newNode = new graphNode(n.data);
                copy.neighbours.add(newNode);
                dfs(n , newNode , visited);
            }else{
                copy.neighbours.add(visited[n.data]);
            }
        }
    }
}