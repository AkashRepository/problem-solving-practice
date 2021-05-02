package greedy;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsTwo {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0)
            return 0;
        Collections.sort(intervals, (a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });
        Queue<Interval> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.end, b.end);
        });
        int max = 1;
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty() && intervals.get(i).start < pq.peek().end) {
                pq.add(intervals.get(i));
                max = Math.max(max, pq.size());
            } else {
                while (!pq.isEmpty() && intervals.get(i).start > pq.peek().end) {
                    pq.poll();
                }
                pq.add(intervals.get(i));

                max = Math.max(max, pq.size());
            }
        }
        return max;
    }
}
