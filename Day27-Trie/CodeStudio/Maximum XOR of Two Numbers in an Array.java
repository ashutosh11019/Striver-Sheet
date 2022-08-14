import java.util.*;
class Node {
    Node links[] = new Node[2]; 
    
    public Node() {
    }
    boolean containsKey(int ind) {
        return (links[ind] != null); 
    }
    Node get(int ind) {
        return links[ind]; 
    }
    void put(int ind, Node node) {
        links[ind] = node; 
    }
};
class Trie {
    private static Node root; 
 
    //Initialize your data structure here
    Trie() {
        root = new Node(); 
    }
    //Inserts a word into the trie
    public static void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(!node.containsKey(bit)) {
                node.put(bit, new Node()); 
            }
            node = node.get(bit); 
        }
    }
    
    public int getMax(int num) {
        Node node = root; 
        int maxNum = 0; 
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit); 
            }
            else {
                node = node.get(bit); 
            }
        }
        return maxNum; 
    }
};
public class Solution {
    public static int maximumXor(int[] A) {
        // Write your Code here
        int n = A.length;
        Trie trie = new Trie(); 
        for(int i = 0;i<n;i++) {
            trie.insert(A[i]); 
        }
        int maxi = 0; 
        for(int i = 0;i<n;i++) {
            maxi = Math.max(maxi, trie.getMax(A[i])); 
        }
        return maxi; 
    }
}