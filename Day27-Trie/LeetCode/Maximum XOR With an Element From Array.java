class Trie{
    Trie left, right;
    int min=Integer.MAX_VALUE;
    
    Trie(){}
}

class Solution {
    void insert(Trie root, int val){
        for(int i = 31 ; i>=0 ; i--){
            int idx = (1<<i) & val;
            if(idx==0){
                if(root.left==null) root.left = new Trie();
                root = root.left;
            }else{
                if(root.right==null) root.right = new Trie();
                root = root.right;
            }
            root.min = Math.min(root.min,val);
        }
    }
    
    int findMaxPair(Trie root ,int val, int max){
        
        int res = -1;
        for(int i = 31 ; i>=0 ; i--){
            int idx = (1<<i) & val;
            if(idx==0){
                if(root.right!=null && root.right.min<=max){
                    root = root.right;
                    if(res==-1) res = 0;
                    res|=(1<<i);
                }else if(root.left!=null && root.left.min<=max){
                    if(res==-1) res = 0;
                    root = root.left;
                }else{
                    return -1;
                }
            }else{
                
                if(root.left!=null && root.left.min<=max){
                    root = root.left;
                    if(res==-1) res = 0;
                    res|=(1<<i);
                }else if(root.right!=null && root.right.min<=max){
                    if(res==-1) res = 0;
                    root = root.right;
                }else{
                    return -1;
                }
                
            }
        }
        return res;
        
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Trie root = new Trie();
        for(int i : nums){
            insert(root,i);
        }
        int res[] = new int[queries.length];
        int i = 0;
        for(int a[] : queries){
            res[i++] = findMaxPair(root,a[0],a[1]); 
        }
        return res;
        
    }
}