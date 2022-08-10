/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        int c=0;
        for(int i=1;i<n;i++){
            if(Runner.knows(c,i)==true) c=i;
        }
        for(int i=0;i<n;i++){
            if(i!=c && (Runner.knows(c,i)==true || Runner.knows(i,c)==false)) return -1;
        }
        return c;
    }
}