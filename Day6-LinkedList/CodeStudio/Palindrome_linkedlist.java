/****************************************************************

    Following is the class structure of the LinkedListNode class:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*****************************************************************/

public class Solution {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        if (slow == null) {
            return true;
        }
        prev.next = null;
        LinkedListNode<Integer> reverseHead = reverse(slow);
        while (head != null) {

            if (!head.data.equals(reverseHead.data)) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;

        }
        return true;

    }

    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> reverseHead = null;

        while (current != null) {

            LinkedListNode<Integer> currentNext = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = currentNext;

        }
        return reverseHead;

    }
}