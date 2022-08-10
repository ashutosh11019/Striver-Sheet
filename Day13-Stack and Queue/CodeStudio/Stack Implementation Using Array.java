import java.util.*;
public class Stack {
    ArrayList<Integer> arr;
    int top = -1;
    int size;
    
    Stack(int size){
        this.size = size;
        this.arr = new ArrayList<Integer>(size);
    }
    
    void push(int num) {
        // Write your code here.
        if(top + 1==size) return;
        else {
            top = top + 1;
            if (arr.size() > top)
                arr.set(top, num);
            else
                arr.add(num);
        }
    }
    
    int pop() {
        // Write your code here.
        if (top == -1) {
            return -1;
        }
        else{
            int x = arr.get(top);
            top--;
            return x;
        }
    }
    
    int top() {
        // Write your code here.
        if (top == -1) { 
            return -1;
        }
        else
            return arr.get(top);
    }
    
    int isEmpty() {
        // Write your code here.
        if(top==-1) return 1;
        else return 0;
    }
    
    int isFull() {
        // Write your code here.
        if(top==size) return 1;
        else return 0;
    }
}
