package dynamicprogramming;

public class MinimumValuePath {

    public int maxPathScore(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
//        for(int[] a:dp)
//            Arrays.fill(a,Integer.MAX_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.min(matrix[i][j], dp[i][j - 1]);
                } else if (j == 0) {
                    dp[i][j] = Math.min(matrix[i][j], dp[i - 1][j]);
                }
//                else if(i==matrix.length-1 && j==matrix[0].length-1){
//                    dp[i][j]=Math.min(Math.min(matrix[i][j],dp[i][j-1]),Math.min(matrix[i][j],dp[i][j-1]));
//                }
                else {
//                    int t = Math.min(Math.min(matrix[i][j], dp[i][j - 1]), Math.min(matrix[i][j], dp[i][j - 1]));
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

//    public void func(int a,int b,int n){
//        if(2*(b-a)+1 < n){
//            // not possible
//        }
//        if(b-a+1 >=n){
//            // return b b-1 b-2 ... a+1, a of size n
//        }
//        int diff  = n - 2*(b-a)+1
//    }


    public static void main(String[] args) {
        MinimumValuePath o = new MinimumValuePath();
        System.out.println(o.maxPathScore(new int[][]{{7, 5, 3}, {2, 0, 9}, {4, 5, 9}}));
    }
}
