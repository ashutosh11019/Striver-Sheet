import java.util.*;
public class Stack {

    // Define the data members.
	Queue<Integer> q = new LinkedList<>();


    public Stack() {
        // Implement the Constructor.
        
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
		return q.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
		if(q.size()==0) return true;
		else return false;
    }

    public void push(int element) {
        // Implement the push(element) function.
		q.add(element);
		for(int i=0;i<q.size()-1;i++){
			q.add(q.remove());
		}
    }

    public int pop() {
        // Implement the pop() function.
		if(q.size()==0) return -1;
		return q.remove();
    }

    public int top() {
        // Implement the top() function.
		if(q.size()==0) return -1;
		return q.peek();
    }
}