/*
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    Where 'N' is the length of the given string.
*/

class TrieNode 
{
    public TrieNode []children = new TrieNode[26];
    TrieNode() 
    {
        for (int i = 0; i < 26; i++) 
        {
            children[i] = null;
        }
    }
}

public class Solution 
{
    private static void insert(String s, int i, TrieNode head) 
    {
        TrieNode temp = head;
        int n = s.length();
        while (i < n) 
        {
            char ch = s.charAt(i);
            if (temp.children[ch - 'a'] == null) 
            {
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
            i++;
        }
    }

    private static int countNodes(TrieNode root) 
    {
        if (root == null) 
        {
            return 0;
        }

        int subTreeNodes = 1;
        for (int i = 0; i < 26; i++) 
        {
            subTreeNodes += countNodes(root.children[i]);
        }

        return subTreeNodes;
    }

    public static int countDistinctSubstrings(String s) 
    {
        int n = s.length();
        TrieNode head = new TrieNode();
        for (int i = 0; i < n; i++) 
        {
            insert(s, i, head);
        }
        int totalNodes = countNodes(head);
        return totalNodes;
    }
}