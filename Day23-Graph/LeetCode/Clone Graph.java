/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        Arrays.fill(visited , null);
        dfs(node , copy , visited);
        return copy;
    }
    
    public void dfs(Node node , Node copy , Node[] visited){
        visited[copy.val] = copy;
        for(Node n : node.neighbors){
            if(visited[n.val] == null){
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n , newNode , visited);
            }else{
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
}