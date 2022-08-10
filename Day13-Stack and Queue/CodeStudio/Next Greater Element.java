import java.util.*;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
		Stack<Integer> st= new Stack<>();
        int[] A= new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())
                A[i]=-1;
            else if(st.peek()>arr[i])
                A[i]=st.peek();
            else {
                while(!st.isEmpty() && st.peek()<=arr[i] )
                    st.pop();
                if(st.isEmpty())
                	A[i]=-1;
                else
                   A[i]=st.peek(); 
            }
            st.push(arr[i]);
        }
		return A;
	}

}
