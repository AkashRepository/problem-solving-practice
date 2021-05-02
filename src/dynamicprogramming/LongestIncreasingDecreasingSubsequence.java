package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingDecreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingDecreasingSubsequence o = new LongestIncreasingDecreasingSubsequence();
        System.out.println(o.longestSubsequenceLength(Arrays.asList(1, 2, 3, 4, 5)));
    }

    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int[][] arr = new int[2][n];
        arr[0][0] = 1;
        for(int i=1;i<n;i++){
            arr[0][i] = 1;
            for(int j=0;j<i;j++){
                if(A.get(j)<A.get(i) && arr[0][j]+1>arr[0][i]){
                    arr[0][i] = arr[0][j]+1;
                }
            }
        }
        arr[1][n-1]=1;
        //[1, 2, 1]
        //1 2 1
        //1 2 1
        int max = arr[0][n-1]+arr[1][n-1]-1;
        for(int i=n-2;i>=0;i--){
            arr[1][i] = 1;
            for(int j=n-1;j>i;j--){
                if(A.get(j)<A.get(i) && arr[1][j]+1>arr[1][i]){
                    arr[1][i] = arr[1][j]+1;
                }
            }
            max = Math.max(max, arr[0][i]+arr[1][i]-1);
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        return max;
    }
}
