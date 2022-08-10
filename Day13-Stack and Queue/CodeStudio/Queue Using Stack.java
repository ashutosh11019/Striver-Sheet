import java.util.*;
public class Queue {
    // Define the data members(if any) here.
	Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    Queue() {
        // Initialize your data structure here.
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
		st1.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
		if(size()==0) return -1;
		if(st2.empty()){
            while(st1.empty()==false){
                st2.push(st1.peek());
                st1.pop();
            }
        }
        int x=st2.peek();
        st2.pop();
        return x;
    }

    int peek() {
        // Implement the peek() function here.
		if(size()==0) return -1;
		if(st2.empty()){
            while(st1.empty()==false){
                st2.push(st1.peek());
                st1.pop();
            }
        }
        return st2.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
		if(size()==0) return true;
        else return false;
    }
	
	public int size(){
        return (st2.size()+st1.size());
    }
}