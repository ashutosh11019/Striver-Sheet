import java.util.*;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        int n=price.size();
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(0);
        for(int i=0; i<n ; i++){
            if(st.isEmpty()) ans.set(i,1);
            else if(st.size()>0 && st.peek().first>price.get(i)) ans.set(i,1);
            else if(st.size()>0 && st.peek().first<=price.get(i)){
                while(st.size()>0 && st.peek().first<=price.get(i)) st.pop();
                if(st.empty()) ans.set(i,i+1);
                else ans.set(i,i-st.peek().second);
            }
            st.push(new Pair(price.get(i),i));
        }
        return ans;
    }
}