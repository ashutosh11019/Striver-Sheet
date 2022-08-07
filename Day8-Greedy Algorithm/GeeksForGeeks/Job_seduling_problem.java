// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->b.profit-a.profit);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           pq.add(arr[i]);
           if(arr[i].deadline>max){
               max = arr[i].deadline;
           }
        }

        int check[] = new int[max+1];
        int count = 0;
        int maxProfit =0;
        while(!pq.isEmpty()){
           Job poll = pq.poll();
           for(int i=poll.deadline;i>=1;i--){
              if(check[i] ==0){
                  check[i] = 1;
                  count++;
                  maxProfit = maxProfit+poll.profit;
                  break;
                  
              }
           }
        }
        return new int[]{count,maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/