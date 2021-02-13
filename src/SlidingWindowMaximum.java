import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum o = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(o.maxSlidingWindow(new int[]{1,3,1,2,0,5},
        3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1)
            return nums;
        int c = 0;
        int[] out = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        out[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            int[] max = pq.peek();
            while (!pq.isEmpty() && max[1] <= i - k) {
                pq.poll();
                max = pq.peek();
            }
            pq.add(new int[]{nums[i], i});
            out[i - k + 1] = pq.peek()[0];
        }
        return out;

    }
}
