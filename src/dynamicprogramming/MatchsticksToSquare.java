package dynamicprogramming;

import java.util.Arrays;

public class MatchsticksToSquare {

    public static void main(String[] args) {
        MatchsticksToSquare o = new MatchsticksToSquare();
        System.out.println(o.makesquare(new int[]{3,3,3,3,4}));
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4==0){
            int n = matchsticks.length;
            int k = sum/4;

            int[] arr = new int[4];
            return couldAdd(0, matchsticks, arr, n, k);



//            int[][] dp = new int[k+1][n];
//
//            for(int i=1;i<=k;i++){
//
//                for(int j=0;j<n;j++){
//                    if(matchsticks[j] <= i){
//                        dp[i][j] = dp[i-matchsticks[j]][j]+1;
//                    }
//                }
//            }
//            for(int[] d: dp)
//                System.out.println(Arrays.toString(d));

        }
        return false;
    }

    private boolean couldAdd(int idx, int[] matchsticks, int[] arr, int n, int k) {

        if(idx>n)
            return false;

        if(arr[0] == arr[1] && arr[1]==arr[2] && arr[2]==arr[3] && arr[0]==k)
            return true;

        for(int i=0;i<4;i++){
            int a = arr[i];
            if(a<k && matchsticks[idx]+a<=k){
                arr[i] = matchsticks[idx]+a;
                if(couldAdd(idx+1, matchsticks, arr, n, k))
                    return true;
                arr[i] = a;
            }
        }

        if(arr[0] == arr[1] && arr[1]==arr[2] && arr[2]==arr[3] && arr[0]==k)
            return true;
        return false;

    }

}
