package dynamicprogramming;

public class TilingWithDominoes {

    private int MOD = 1_000_000_007;

    public int solve(int A) {

        // state 0
//        |X|X| |     |X| | |
//        |Y|Y| | + 2*|X| | |
//        |Z|Z| |     |Y|Y| |
//         0 1 2 3     0 1 2

        long[] arr = new long[A+1];
        long[] brr = new long[A+1];

        arr[0] = 1;
        arr[1] = 0;
        brr[0] = 0;
        brr[1] = 1;

        for(int i=2;i<=A;i++){
            arr[i] = (arr[i-2]%MOD + brr[i-1]%MOD + brr[i-1]%MOD)%MOD;
            brr[i] = (arr[i-1]%MOD + brr[i-2]%MOD)%MOD;
        }
        return (int)arr[A]%MOD;
    }
}
