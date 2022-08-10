import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
        int n=str.length();
        int m=pat.length();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int hashP=0;
        int hashT=0;
        for(int i=0;i<m;i++){
            hashP+=((pat.charAt(i)-'A'+1)*(int)Math.pow(5,i));
            hashT+=((str.charAt(i)-'A'+1)*(int)Math.pow(5,i));
        }

        int flag=0;
        if(hashP==hashT){
            boolean isEqual=true;
            for(int i=0;i<m;i++){
                if(pat.charAt(i)!=str.charAt(i)){
                    isEqual=false;
                    break;
                }
            }
            if(isEqual){
                ans.add(0);
            }
        }

        flag=0;
        for(int i=m;i<n;i++){
            hashT=((hashT-(str.charAt(i-m)-'A'+1))/5)+((str.charAt(i)-'A'+1)*(int)Math.pow(5,m-1));
            if(hashT==hashP){
                boolean isEqual=true;
                for(int j=0;j<m;j++){
                    if(pat.charAt(j)!=str.charAt(i-m+1+j)){
                        isEqual=false;
                        break;
                    }
                }
                if(isEqual){
                    ans.add(i-m+1);
                }
            }
        }
        return ans;
	}
}