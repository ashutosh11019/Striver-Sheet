/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {
        //Your code goes here
		if(head == null) return false;
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
    }
}