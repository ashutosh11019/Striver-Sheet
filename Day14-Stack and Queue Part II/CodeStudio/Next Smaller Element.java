import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(0);
        for(int i=n-1 ; i>=0 ; i--)
        {
            int val = arr.get(i);
            while(st.peek()>=val){
                st.pop();
            }
            ans.set(i, st.peek());
            st.add(val);
        }
        return ans ;
    }
}