package dynamicprogramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length() + 1][t2.length() + 1];
        for (int i = 0; i <= t1.length(); i++) {
            for (int j = 0; j <= t2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1.length()][t2.length()];
    }



    public static void main(String[] args) {
        LongestCommonSubsequence o = new LongestCommonSubsequence();
        System.out.println(o.longestCommonSubsequence("abcde", "ace"));
    }
}
