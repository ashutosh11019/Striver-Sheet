import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
        Node dummy = new Node(0);
   
        Node cur = head;
        Node prev = dummy;
        prev.next = head;

        int count = 0;    
        while(cur != null && count < n){
            Node temp1 = cur;
            Node prev1 = prev;
            int j = b[count];
            if(j>0){
                while(cur != null && j>0){
                    Node temp2 = cur;
                    cur = cur.next;
                    temp2.next = prev1;
                    prev1 = temp2;
                    j--;
                }
                prev.next = prev1;
                prev = temp1;
                prev.next = cur;
            }
            count++;
       }
       return dummy.next;
	}
}