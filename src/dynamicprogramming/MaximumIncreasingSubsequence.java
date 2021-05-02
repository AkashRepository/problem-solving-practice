package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumIncreasingSubsequence {

    /*
    time complexity : O(N*N)
     */
    public int max(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    /*
    time complexity : O(Nlog(N))
     */
    public int lis(final List<Integer> A) {

        int[] arr = new int[A.size()];

        List<Integer> out = new ArrayList<>();
        int n = A.size();
        out.add(A.get(0));
        int len = 0;
        for (int i = 1; i < n; i++) {
            int val = A.get(i);
            if (val < out.get(0)) {
                out.set(0, val);
                arr[i] = 1;
            } else if (val > out.get(len)) {
                out.add(val);
                len++;
                arr[i] = len;
            } else {
                int idx = Collections.binarySearch(out, val);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                arr[i] = idx;
                out.set(idx, val);
            }
        }
        return out.size();
    }

    public static void main(String[] args) {
        MaximumIncreasingSubsequence o = new MaximumIncreasingSubsequence();
        System.out.println(o.max(new int[]{10,9,2,5,3,7,101,18}));
    }
}
