package dynamicprogramming;

import java.util.Arrays;

public class MaximumIncreasingSubsequence {

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

    public static void main(String[] args) {
        MaximumIncreasingSubsequence o = new MaximumIncreasingSubsequence();
        System.out.println(o.max(new int[]{10,9,2,5,3,7,101,18}));
    }
}
