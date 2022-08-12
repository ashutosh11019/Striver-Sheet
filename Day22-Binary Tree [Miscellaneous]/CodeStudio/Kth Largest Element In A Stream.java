import java.util.*;
public class Kthlargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int size;
    Kthlargest(int k, int[] arr) {
        // Write your code here.
        size=k;
        for(int i=0;i<arr.length;i++)
        {
            q.add(arr[i]);
            if(q.size()>k)
            {
                q.poll();
            }
        }
    }

    void add(int num) {
        // Write your code here.
        q.add(num);
        if(q.size()>size)
        {
            q.poll();
        }
    }

    int getKthLargest() {
        // Write your code here.
        int a= q.peek();
        return a;
    }
}
