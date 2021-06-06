package dynamicprogramming;

public class PaintHouseTwo {

    public int minCostII(int[][] costs) {

        int n = costs.length;
        if(n==0)
            return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i=0;i<k;i++){
            dp[0][i] = costs[0][i];
            if(dp[0][i]<min){
                min2 = min;
                min = dp[0][i];
                minIdx = i;
            } else if(dp[0][i]<min2){
                min2 = dp[0][i];
            }
        }
        int minOld = min;
        int min2Old = min2;
        int minIdxOld = minIdx;
        for(int i=1;i<n;i++){
            min = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            minIdx = -1;
            for(int j=0;j<k;j++){
                if(minIdxOld==j){
                    dp[i][j] = min2Old + costs[i][j];
                } else {
                    dp[i][j] = minOld + costs[i][j];
                }

                if(dp[i][j]<min){
                    min2 = min;
                    min = dp[i][j];
                    minIdx = j;
                } else if(dp[i][j]<min2){
                    min2 = dp[i][j];
                }
            }

            minOld = min;
            min2Old = min2;
            minIdxOld = minIdx;
        }
        return min;
    }
}
