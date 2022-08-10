class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        // if(haystack.length()==0) return -1;
        // if(needle.length() > haystack.length()) return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            String str = haystack.substring(i, needle.length()+i);
            if(needle.equals(str)){
                return i;
            }
        }
        return -1;
    }
}