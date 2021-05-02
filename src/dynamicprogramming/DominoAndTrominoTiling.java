package dynamicprogramming;

public class DominoAndTrominoTiling {

    private int MOD = 1_000_000_007;

    public int numTilings(int N) {
        long[][] a = new long[N+1][2];
        a[0][0]=1;
        a[0][1]=0;
        a[1][0]=1;
        a[1][1]=1;
        for(int i=2;i<=N;i++){
            a[i][0] = (a[i-2][0] + 2*a[i-2][1] + a[i-1][0])%MOD;
            a[i][1] = (a[i-1][0] + a[i-1][1])%MOD;


            // a[i][0] = a[i-2][0] + a[i-2][1] + a[i-2][2] + a[i-1][0];
            // a[i][1] = a[i-1][0] + a[i-1][2];
            // a[i][2] = a[i-1][0] + a[i-1][1];
        }
        return (int)a[N][0]%MOD;
    }
}
