package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceEngineer {

    public static void main(String[] args) {
        MaximumPerformanceEngineer o = new
                MaximumPerformanceEngineer();
        System.out.println(o.maxPerformance(6, new int[] {2,10,3,1,5,8}, new int[]{5,4,3,9,7,2},2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a,b) -> {
            return Integer.compare(b[0],a[0]);
        });

        Queue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long min = 0;
        int i = 0;
        for(;i<k;i++){
            sum = sum + arr[i][1];
            pq.add(arr[i][1]);
            min = Math.max(min, sum*arr[i][0]);
        }
        while(i<n && !pq.isEmpty()){
            sum = sum - pq.poll();
            sum = sum + arr[i][1];
            pq.add(arr[i][1]);
            min = Math.max(min, sum*arr[i][0]);
            i++;
        }
        return (int)(min%MOD);
    }
}
