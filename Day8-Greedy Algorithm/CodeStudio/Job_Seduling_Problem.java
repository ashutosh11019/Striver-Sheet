import java.util.*;

class Job {
   int profit, deadline;
   Job(int y, int z) {
      this.deadline = y;
      this.profit = z;
   }
}

public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        int n=jobs.length;
        Job[] arr = new Job[jobs.length];
        for(int i=0;i<jobs.length;i++){
            arr[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        
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
        return maxProfit;
    }
}
