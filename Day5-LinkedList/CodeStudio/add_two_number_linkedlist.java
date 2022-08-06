/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        // Write your code here.
		LinkedListNode l = null;
        LinkedListNode temp = null;
        int carry=0,sum=0;
        while(l1!=null || l2!=null){
            sum=carry;
            if(l1!=null){
                sum=sum+l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum=sum+l2.data;
                l2=l2.next;
            }
            LinkedListNode node = new LinkedListNode(sum%10);
            carry=sum/10;
            if(temp==null){
                temp = l = node;
            }
            else{
                temp.next = node;
                temp = temp.next;
            }
        }
        if(carry>0){
            temp.next = new LinkedListNode(carry);
        }
        return l;
    }
}