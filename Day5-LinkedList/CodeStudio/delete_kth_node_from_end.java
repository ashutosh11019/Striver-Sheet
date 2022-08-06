/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
		// Write your code here.
        if(head==null) return head;
        if(K==0) return head;
		LinkedListNode<Integer> start = new LinkedListNode(0);
        start.next = head;
        LinkedListNode<Integer> fast = start;
        LinkedListNode<Integer> slow = start;     

        for(int i = 1; i <= K; ++i)
            fast = fast.next;
    
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
	}
}
