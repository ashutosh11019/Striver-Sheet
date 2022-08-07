/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head==null||head.next==null) return head;
        Node dummy=new Node(0);
        dummy.next=head;
        Node fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)
            fast=fast.next;

        for (int j=i-k%i;j>0;j--)
            slow=slow.next;

        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}