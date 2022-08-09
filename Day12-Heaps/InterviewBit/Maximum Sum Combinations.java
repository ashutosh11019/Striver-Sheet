public class Solution {
    public static class Pair {
 
        public Pair(int l, int m)
        {
            this.l = l;
            this.m = m;
        }
 
        int l;
        int m;
 
        @Override public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair)o;
            return (l == obj.l && m == obj.m);
        }
 
        @Override public int hashCode()
        {
            return Objects.hash(l, m);
        }
    }
 
    public static class PairSum implements Comparable<PairSum> {
 
        public PairSum(int sum, int l, int m)
        {
            this.sum = sum;
            this.l = l;
            this.m = m;
        }
 
        int sum;
        int l;
        int m;
 
        @Override public int compareTo(PairSum o)
        {
            return Integer.compare(o.sum, sum);
        }
    }
    
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int K) {
        int N=A.size();
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<PairSum> sums = new PriorityQueue<PairSum>();
        HashSet<Pair> pairs = new HashSet<Pair>();
        int l = N - 1;
        int m = N - 1;
        pairs.add(new Pair(l, m));
        sums.add(new PairSum(A.get(l) + B.get(m), l, m));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < K; i++)
        {
            PairSum max = sums.poll();
            ans.add(max.sum);
            l = max.l - 1;
            m = max.m;
            if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m))){
                sums.add(new PairSum(A.get(l) + B.get(m), l, m));
                pairs.add(new Pair(l, m));
            }
            l = max.l;
            m = max.m - 1;
            if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m)))
            {
                sums.add(new PairSum(A.get(l) + B.get(m), l, m));
                pairs.add(new Pair(l, m));
            }
        }
        return ans;
    }
}
