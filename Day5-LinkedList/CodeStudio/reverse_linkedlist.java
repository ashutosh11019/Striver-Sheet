/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		LinkedListNode<Integer> cur = null;
		while(head != null){
			LinkedListNode<Integer> next = head.next;
			head.next = cur;
			cur = head;
			head = next;
		}
		return cur;
    }
}