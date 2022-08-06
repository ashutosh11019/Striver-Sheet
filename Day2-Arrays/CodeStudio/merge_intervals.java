/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
        ArrayList<Interval> merged = new ArrayList<>();
        for (int i=0;i<intervals.length;) {
			int j=i+1;
			while(j<intervals.length && intervals[j].start<1+intervals[i].finish){
				intervals[i].finish=Math.max(intervals[i].finish, intervals[j].finish);
				++j;
			}
			merged.add(intervals[i]);
			i=j;
        }
        return merged;
    }
}
