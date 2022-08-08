public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
            for(int j=0;j<A.get(0).size();j++)
            {
                ans.add(A.get(i).get(j));
            }
        }
        
        Collections.sort(ans);
        int m=ans.size()/2;
        int x=ans.get(m);
        return x;
    }
}
