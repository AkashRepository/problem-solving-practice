package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hurry {

    public static void main(String[] args) {
        int[][] tasks = new int[][]{{2,8},{4,2},{5,1}};
        int t = 16;
        int n = 3;
        int out = solve(n,t, tasks);
        System.out.println(out);
    }

    private static int solve(int n, int t, int[][] tasks) {
        String str = "";
        int out = 0;
        Arrays.sort(tasks, (a,b) -> Integer.compare(a[0],b[0]));
        Queue<int[]> pq= new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int tt = 0;
        int at = 0;
        for(int i=0;i<n;i++){
            tt = tt + tasks[i][0] - at;
            at = tasks[i][0];
            pq.add(tasks[i]);
            int time = tt + tasks[i][1] + at;
            while(time>t && !pq.isEmpty()){
                int[] pqt = pq.poll();
                time = time - pqt[1];
                tt = tt - pqt[1];
                out++;
            }
            tt = tt + tasks[i][1];
        }

        return n-out;
    }
}
