//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class pair{
   int start,end;
   public pair(int s,int e){
       start=s;
       end=e;
   }
}

class comp implements Comparator<pair>{
   public int compare(pair a,pair b){
       return a.end-b.end;
   }
}

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<pair> ans = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            ans.add(new pair(start[i],end[i]));
        } 
       
        Collections.sort(ans,new comp());
       
        int i=0,j=1,count=1;
        while(j<n){
            if(ans.get(i).end<ans.get(j).start){
                count++;
                i=j;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}