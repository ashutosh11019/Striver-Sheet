public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        int sign=1;
        int i=0;
        int ans=0;
        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        for(;i<str.length();i++){
            if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9){
                ans=ans*10+str.charAt(i)-'0';
            }
        }
        return ans*sign;
    }
    
    static int strStr(String a, String b){
        if(b.indexOf(a) < b.length())
            return b.indexOf(a);
        else
            return -1;
    }
}
