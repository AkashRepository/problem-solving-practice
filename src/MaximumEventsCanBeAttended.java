import java.util.*;

public class MaximumEventsCanBeAttended {

    public static void main(String[] args) {
        MaximumEventsCanBeAttended o = new MaximumEventsCanBeAttended();
        System.out.println(o.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        if (events.length == 1)
            return 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> m = new HashMap<>();
        for (int[] i : events) {
            m.putIfAbsent(i[0], new ArrayList<>());
            m.get(i[0]).add(i[1]);
            max = Math.max(max, i[1]);
        }
        int out = 0;
        int curr = 1; //day 1
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (curr <= max) {
            List<Integer> v = m.get(curr);
            if (v != null && !v.isEmpty()) {
                pq.addAll(v);
            }
            boolean flag = false;
            while (!pq.isEmpty()) {
                if (pq.poll() >= curr) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                out++;
            curr++;
        }
        return out;
    }
}
