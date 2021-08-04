package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameFour {

    public int jumpGameFour(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        int out = nums[0];
        pq.add(new int[]{0, nums[0]});
        int i = 1;
        int n = nums.length;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek()[0] < i - k) {
                pq.poll();
            }
            int largest = 0;

            if (!pq.isEmpty()) {
                largest = pq.peek()[1];
            }
            if (i == n - 1) {
                out = nums[i] + largest;
            }
            pq.add(new int[]{i, nums[i] + largest});
            i++;
        }

        return out;

        // DP solution TLE
        // int n = nums.length;
        // if(n==1)
        //     return nums[0];
        // // int i = n-1;
        // int[] arr = new int[n];
        // Arrays.fill(arr, Integer.MIN_VALUE);
        // arr[0] = nums[0];
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<=i+k && j<n;j++){
        //         arr[j] = Math.max(arr[i]+nums[j], arr[j]);
        //     }
        // }
        // return arr[n-1];
    }
}
