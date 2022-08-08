import java.util.*;
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
       long s=0;
       long sum=0;
       long ans=-1;
       for (int i=0;i<m;i++){
           sum+=time[i];
       }
       long e = sum;
       long mid = s + (e-s)/2;
       while(s<=e){
           if(isPossible(n,m,time,mid)){
               e=mid-1;
               ans=mid;
           }else{
               s=mid+1;
           }
           mid = s + (e-s)/2;
       }
       return ans;
    }
    
    static boolean isPossible(int n, int m, int[] time,long mid){
       int dayCount = 1;
       long timeSum = 0;
       for(int i=0;i<m;i++){
           if(timeSum+time[i]<=mid){
               timeSum+=time[i];
           }else{
               dayCount++;
               if(dayCount>n || time[i]>mid){
                   return false;
               }
               timeSum=time[i];
           }
       }
       return true;
    }
}