package heap;

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {

//    https://leetcode.com/problems/minimum-interval-to-include-each-query/

    public int[] minInterval(int[][] intervals, int[] queries) {


//         1 2 3 4 5 6 7 8
//         1     1
//           2   2
//             3     3
//               4,4

//        4 3 3  1
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));
        int[][] qi = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            qi[i][0] = queries[i];
            qi[i][1] = i;
        }
        Arrays.sort(queries);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int i = 0, n = intervals.length;
        int t=0;
        int[] out = new int[queries.length];
        for(int q: queries){
            while(i<n && intervals[i][0]<=q){
                pq.add(new int[]{intervals[i][1], intervals[i][1] - intervals[i][0] + 1});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[0]<q){
                pq.poll();
            }
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[1]);
        }
        for(int[] q: qi){
            out[q[1]] = map.get(q[0]);
        }
        return out;
    }
}
