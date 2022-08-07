/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		int lenA=length(firstHead), lenB=length(secondHead);
		while(lenA > lenB){
			firstHead = firstHead.next;
			lenA--;
		}
		while(lenA < lenB){
			secondHead = secondHead.next;
			lenB--;
		}
		while(firstHead != secondHead){
			firstHead = firstHead.next;
			secondHead = secondHead.next;
		}
		if(firstHead == null) return -1;
		return firstHead.data;
	}
	
	public static int length(LinkedListNode<Integer> node){
		int length = 0;
		while(node != null){
			node = node.next;
			length++;
		}
		return length;
	}
}