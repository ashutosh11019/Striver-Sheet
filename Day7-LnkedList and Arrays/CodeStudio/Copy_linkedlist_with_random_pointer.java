import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		if(head == null) return null;
		Map<LinkedListNode<Integer>, LinkedListNode<Integer>> map = new HashMap<>();
		LinkedListNode<Integer> node = head;
		while(node != null){
			map.put(node, new LinkedListNode<Integer>(node.data));
			node = node.next;
		}
		node = head;
		while(node != null){
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		return map.get(head);
	}
}
