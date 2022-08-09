
import java.util.*;
// import java.util.PriorityQueue;

public class Solution {
    static PriorityQueue<Integer> maxheap=new PriorityQueue(Collections.reverseOrder());
    static PriorityQueue<Integer> minheap=new PriorityQueue();
    
	public static void findMedian(int arr[])  {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
        for(int num: arr){
            addNum(num);
            System.out.print(findMedian()+" ");
        }
    }

    public static void addNum(int num) {
        if(maxheap.isEmpty()||maxheap.peek()>=num)
            maxheap.add(num);
        else
            minheap.add(num);
    
        if(maxheap.size()>minheap.size()+1)
            minheap.add(maxheap.poll());
        else if(maxheap.size()<minheap.size())
            maxheap.add(minheap.poll());
    }
    
    public static int findMedian() {
        if(maxheap.size()==minheap.size())
            return (maxheap.peek()+minheap.peek())/2;
        return maxheap.peek();
    }
}