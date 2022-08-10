import java.util.*;

public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        if(str1 == str2) return true;
        if(str1.length() != str2.length()) return false;
        str1 = sortString(str1);
        str2 = sortString(str2);
        if(str1.equals(str2)) return true;
        return false;
    }
    
    public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}