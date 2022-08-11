import java.util.*;

class Node{
    int height;
    int left;
    int right;
    Node(int height, int left, int right){
        this.height=height;
        this.left=left;
        this.right=right;
    }
}

public class Solution {
    public static int heightOfTheTree(int[] inorder, int[] level, int N){
        // Write your code here.
        Queue<Node> q = new LinkedList<>();
        Node it = new Node(0, 0, N-1);
        q.add(it);
        int pos[] = new int[N+1];
        for(int i=0;i<N;i++){
            pos[inorder[i]]=i;
        }
        int mxheight=0;
        for(int i=0;i<N;i++){
            int curr=level[i];
            Node now=q.peek();
            q.poll();
            int currPos=pos[curr];
            if(currPos>now.left)
            {
                Node newNode = new Node(now.height+1, now.left, currPos-1);
                mxheight=Math.max(mxheight,newNode.height);
                q.add(newNode);
            }
            if(currPos<now.right)
            {
                Node newNode = new Node(now.height+1, currPos+1, now.right);;
                mxheight=Math.max(mxheight,newNode.height);
                q.add(newNode);
            }
        }
       return mxheight;
    }
}