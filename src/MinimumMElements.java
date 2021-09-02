import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumMElements {

    public static void main(String[] args) {

    }

    public int[] twoTimes(int[] A, int M) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int n = A.length;
        int i = 0, j = 0;

        for (i = 0; i < n; i++) {
            pq.add(new int[]{i, A[i]});
        }
        int[] B = new int[A.length];
        i = 0;
        while (i != M) {
            int[] u = pq.poll();
            B[u[0]] = 2 * u[1];
            i++;
        }
        for (i = 0; i < n; i++) {
            if (B[i] == 0)
                B[i] = A[i];
        }
        return B;
    }

}
