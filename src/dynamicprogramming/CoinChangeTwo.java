package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeTwo {

    //https://www.interviewbit.com/problems/coin-sum-infinite/

    public static void main(String[] args) {
        CoinChangeTwo o = new CoinChangeTwo();
        System.out.println(o.coinchange2(Arrays.asList(1,2,3),4));
    }

    public int coinchange2(List<Integer> A, int B) {

        int[] dp = new int[B+1];
        dp[0] = 1;
        for(int i=0;i<A.size();i++){
            for(int j=A.get(i);j<=B;j++){
                // int k = 1;
                dp[j] = (dp[j] + dp[j-A.get(i)])%1000007;
                // k++;
            }
        }
        return dp[B]%1000007;
    }
}
