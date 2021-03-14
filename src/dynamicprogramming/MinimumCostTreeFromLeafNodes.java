package dynamicprogramming;

public class MinimumCostTreeFromLeafNodes {

    public int tabulation(int n, int[] arr) {
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++)
            dp[i][i][0] = arr[i];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1][1] = arr[i] * arr[i + 1];
            dp[i][i + 1][0] = Math.max(arr[i], arr[i + 1]);
        }

        for (int l = 2; l < n; l++) {

            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                dp[i][j][1] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][k][0] * dp[k + 1][j][0] + dp[i][k][1] + dp[k + 1][j][1]);
                    dp[i][j][0] = Math.max(dp[i][k][0], dp[k + 1][j][0]);
                }
            }

        }
        return dp[0][n - 1][1];

    }
        // solve like matrix multiplication problem
    private int[] recursive(int start, int end, int[] arr, int[][][] dp){

        if(start==end){

            dp[start][end] = new int[]{arr[start],0};
            return dp[start][end];
        }
        if(dp[start][end]!=null){

            return dp[start][end];
        }

        int sum = Integer.MAX_VALUE;
        int value = Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            int[] value1 = recursive(start, i, arr, dp);
            int[] value2 = recursive(i+1, end, arr, dp);

            sum = Math.min(sum, value1[0] * value2[0] + value1[1] + value2[1]);
            value = Math.max(value, Math.max(value1[0], value2[0]));

        }
        int[] out =  new int[]{value, sum};
        dp[start][end] = out;
        return out;
    }

    public int mctFromLeafValues(int[] arr) {

        int n = arr.length;
        int[][][] dp = new int[n][n][];

        return recursive(0, n-1, arr, dp)[1];

    }
}
