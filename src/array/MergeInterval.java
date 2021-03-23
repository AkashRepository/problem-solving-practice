package array;

import java.util.ArrayList;
import java.util.Collections;

public class MergeInterval {



     public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> out  =new ArrayList<>();
        int n = intervals.size();
        if(n==1){
            return intervals;
        }
        int i=0, j=0;
        // 1, 3 2, 5 9, 10
        intervals.sort((a, b) -> a.start - b.start);
        while(i<n){
            int start = intervals.get(i).end;
            while(j<n && intervals.get(j).start<=start){
                start = Math.max(start, intervals.get(j).end);
                j++;
            }
            out.add(new Interval(intervals.get(i).start, start));
            i = j;
            j = i;
        }

        return out;
    }

}
