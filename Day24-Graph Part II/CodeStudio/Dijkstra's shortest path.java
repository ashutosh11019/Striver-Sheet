/*
    Time complexity: O(E*log(V))
    Space complexity: O(V^2)

    Where 'E' is the number of edges and 'V' is
    the number of vertices in a graph.
*/

import java.util.*;
import javafx.util.Pair;

public class Solution {
    public static ArrayList < Integer > dijkstraHelper(ArrayList < ArrayList < Pair < Integer, Integer >>> adjacencyList, int vertices, int source) {
        
        PriorityQueue < Pair < Integer, Integer > > pq = new PriorityQueue < Pair < Integer, Integer >> (vertices, Comparator.comparing(Pair::getKey));
        ArrayList < Integer > distance = new ArrayList < Integer > (vertices);
        
        for (int i = 0; i < vertices; i++) {
            distance.add(Integer.MAX_VALUE);
        }

        pq.add(new Pair < Integer, Integer > (0, source));

        distance.set(source, 0);
        ArrayList < Boolean > visited = new ArrayList < Boolean > (vertices);

        for (int i = 0; i < vertices; i++) {
            visited.add(false);
        }

        while (!pq.isEmpty()) {
            int u = pq.peek().getValue();
            pq.remove();
            visited.set(u, true);
            for (int it = 0; it < adjacencyList.get(u).size(); it++) {
                int v = adjacencyList.get(u).get(it).getKey();
                int dist = adjacencyList.get(u).get(it).getValue();

                if (visited.get(v) == false && distance.get(v) > distance.get(u) + dist) {
                    distance.set(v, distance.get(u) + dist);
                    pq.add(new Pair < Integer, Integer > (distance.get(v), v));
                }
            }
        }

        return distance;
    }

    public static ArrayList < Integer > dijkstra(ArrayList < ArrayList < Integer > > vec, int vertices, int edges, int source) {

      ArrayList < ArrayList < Pair < Integer, Integer > > > adjacencyList = new ArrayList < ArrayList < Pair < Integer, Integer >>> (vertices);
      
      for (int i = 0; i < vertices; i++) {
          adjacencyList.add(new ArrayList < Pair < Integer, Integer >> ());
      }
      for (int i = 0; i < (int) vec.size(); i++) {
          adjacencyList.get(vec.get(i).get(0)).add(new Pair < Integer, Integer > (vec.get(i).get(1), vec.get(i).get(2)));
          adjacencyList.get(vec.get(i).get(1)).add(new Pair < Integer, Integer > (vec.get(i).get(0), vec.get(i).get(2)));
      }

      return dijkstraHelper(adjacencyList, vertices, 0);
    }
}