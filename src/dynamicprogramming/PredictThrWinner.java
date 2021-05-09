package dynamicprogramming;

public class PredictThrWinner {

    public boolean PredictTheWinner(int[] nums) {

        // return traverse(0, nums.length-1, nums, true)>=0;
        int n = nums.length;
        int[][] dp = new int[n][n];


        for(int s=n-1;s>=0;s--){
            dp[s][s] = nums[s];
            for(int e=s+1;e<n;e++){
                dp[s][e] = Math.max( nums[s] - dp[s+1][e],nums[e] - dp[s][e-1]);
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j = 0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1]>=0;
    }


    private int traverse(int i, int j, int[] nums, boolean player1){
        if(i==j){
            return player1 ? nums[i] : -nums[i];
        }
        if(player1){
            return Math.max(traverse(i+1, j, nums, !player1) + nums[i]
                    ,traverse(i, j-1, nums, !player1) + nums[j]);
        } else {
            return Math.min(traverse(i+1, j, nums, !player1) - nums[i]
                    ,traverse(i, j-1, nums, !player1) - nums[j]);
        }
    }
}
