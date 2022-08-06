/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		// Write your code here.
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.data < l2.data){
			l1.next = sortTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = sortTwoLists(l1, l2.next);
			return l2;
		}
	}
}
