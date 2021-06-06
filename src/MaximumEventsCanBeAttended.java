import java.util.*;

public class MaximumEventsCanBeAttended {

    public static void main(String[] args) {
        MaximumEventsCanBeAttended o = new MaximumEventsCanBeAttended();
        System.out.println(o.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        int out = 0;
        int curr = 1; //day 1
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        while (i < n || !pq.isEmpty()) {

            while(i<n && events[i][0] <= curr){
                pq.add(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek() < curr){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                out++;
            }

            curr++;
        }


        return out;

    }
}
