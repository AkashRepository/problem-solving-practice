import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayAtleastK {

    public static void main(String[] args) {
        SumOfSubarrayAtleastK o =new SumOfSubarrayAtleastK();
//        System.out.println(o.shortestSubarray(new int[]{84,-37,32,40,95},
//        167));
        System.out.println(o.shortestSubarray(new int[]{-28,81,-20,28,-29},
        89));
        System.out.println(o.shortestSubarray(new int[]{1,2},
        4));
    }

    public int shortestSubarray(int[] A, int K) {
        int i=1;
        int min = Integer.MAX_VALUE;
        int n = A.length;
        int[] sum = new int[n+1];
        for(i=1;i<=n;i++){
            sum[i]=sum[i-1]+A[i-1];
        }

        if(n==1){
            return A[0]>=K?1:-1;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(i=0;i<=n;i++){
            while(!dq.isEmpty() && sum[i] - sum[dq.peekFirst()]>=K){
                min = Math.min(min, i-dq.pollFirst());
            }
            while(!dq.isEmpty() && sum[i]<sum[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
