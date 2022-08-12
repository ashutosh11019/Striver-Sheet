public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> m = new HashMap<>();
        ArrayList<Integer> v = new ArrayList<>();
        for(int i = 0;i<B;i++){
            m.put(A.get(i), m.getOrDefault(A.get(i),0)+1);
        }
        v.add(m.size());
    
        for(int i = B;i<A.size();i++){
            m.put(A.get(i-B), m.getOrDefault(A.get(i-B),0)-1);
            if( m.get(A.get(i-B)) == 0) {
                m.remove(A.get(i-B));
            }
            m.put(A.get(i), m.getOrDefault(A.get(i),0)+1);
            v.add(m.size());
        }
    
        return v;
    }
}
