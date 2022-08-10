import java.util.*;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] ns = nextSmaller(a, n);
        int[] ps = prevSmaller(a, n);
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            int l=(ns[i]-ps[i]-1)-1; 
            if(a[i]>ans[l]) ans[l]=a[i];
        }
        for(int i=n-2;i>=0;i--){
            if(ans[i]<ans[i+1]) ans[i]=ans[i+1];
        } 
        return ans;
    }
    
    static int[] nextSmaller(int[] a, int n){
        int[] arr = new int[n];
        Arrays.fill(arr, n);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(a[n-1],n-1));
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek().first>=a[i]) st.pop();
            if(!st.isEmpty()) arr[i]=st.peek().second;
            st.push(new Pair(a[i],i));
        }
        return arr;
    }
    
    static int[] prevSmaller(int[] a, int n){
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(a[0],0));
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && st.peek().first>=a[i]) st.pop();
            if(!st.isEmpty()) arr[i]=st.peek().second;
            st.push(new Pair(a[i],i));
        }
        return arr;
    }
}

