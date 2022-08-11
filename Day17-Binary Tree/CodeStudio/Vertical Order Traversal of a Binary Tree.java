/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

/*
    Time Complexity - O(N)
    Space Complexity - O(N)

    Where N is the number of nodes in the Binary Tree.
*/

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;

class Pair
{
    public TreeNode<Integer> root;
    public int hDistance;
    Pair(TreeNode<Integer> root, int hDistance)
    {
        this.root = root;
        this.hDistance = hDistance;
    }
}

public class Solution
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
        {
            return result;
        }
        Map<Integer, ArrayList<Integer>> store = new TreeMap<Integer, ArrayList<Integer>>();
        int hd = 0;
        Queue<Pair> level = new LinkedList<Pair>();

        level.add(new Pair(root, hd));

        while (level.isEmpty() == false)
        {
            Pair temp = level.remove();

            hd = temp.hDistance;

            TreeNode<Integer> node = temp.root;
            ArrayList<Integer> element = store.get(hd);
            if (element == null)
            {
                element = new ArrayList<Integer>();
            }
            element.add(node.data);
            store.put(hd, element);
            if (node.left != null)
            {
                level.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null)
            {
                level.add(new Pair(node.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> it : store.entrySet())
        {
            for (int i = 0; i < it.getValue().size(); ++i)
            {
                result.add(it.getValue().get(i));
            }
        }

        return result;
    }
}