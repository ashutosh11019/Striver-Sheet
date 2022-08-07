import java.util.*;

class pair{
   int start,end;
   public pair(int s,int e){
       start=s;
       end=e;
   }
}

class comp implements Comparator<pair>{
   public int compare(pair a,pair b){
       return a.end-b.end;
   }
}

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        ArrayList<pair> ans = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            ans.add(new pair(start.get(i),end.get(i)));
        }
        Collections.sort(ans,new comp());
        int res = 1;
        int prev = ans.get(0).end;
        for(int i=1; i<start.size(); i++){
            if(ans.get(i).start >= prev){
                prev = ans.get(i).end;
                res++;
            }
        }
        return res;
    }
}