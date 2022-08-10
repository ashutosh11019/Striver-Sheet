public class Solution {
    public static String writeAsYouSpeak(int n) {
        // Write your code here.
        String result = "1";
        for(int i = 2; i <= n; i++){
            result = next(result);
        }
        return result;
    }
    
    private static String next(String input) {
        StringBuilder sb = new StringBuilder();
        char[] arr = input.toCharArray();
        char curr = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == curr){
                count++;
            } else {
                sb.append(count).append(curr);
                curr = arr[i];
                count = 1;
            }
        }
        sb.append(count).append(curr);
        return sb.toString();
    }
}