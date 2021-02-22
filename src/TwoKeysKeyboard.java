public class TwoKeysKeyboard {


    public static void main(String[] args) {
        TwoKeysKeyboard o = new TwoKeysKeyboard();
        System.out.println(o.minSteps(4));
        System.out.println(o.calc2(4));
    }

    public int calc2(int n){
        int ans=0,d=2;
        while(n>1){
            while(n%d==0){
                ans+=d;
                n=n/d;
            }
            d++;
        }
        return ans;
    }

    private int calc(int n, int[] dp){
        int out = Integer.MAX_VALUE;
        if(n==1)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        for(int i=2;i<n;i++) {
            if(n%i==0){
                out = Math.min(out,calc(i, dp) + n/i);
            }
        }
        if(out==Integer.MAX_VALUE) {
            dp[n]=n;
            return n;
        }
        dp[n]=out;
        return out;
    }

    public int minSteps(int n) {
        int[] dp = new int[n+1];
        return calc(n,dp);
    }


}
