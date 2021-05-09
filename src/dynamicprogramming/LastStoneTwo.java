package dynamicprogramming;

public class LastStoneTwo {
    public int lastStoneWeightII(int[] stones) {

        //4 - 2 + 8 - 7 + 2 - 1 + 1 - () - ()
        //4 + 8 + 2 + 1 + 1 -
        int n = stones.length;
        int sum = 0;
        for(int a: stones)
            sum = sum + a;
        int t = sum;
        sum = sum/2;
        int[][] arr = new int[sum+1][n+1];

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                if(i>=stones[j-1])
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-stones[j-1]][j-1] + stones[j-1]);
                else
                    arr[i][j] = arr[i][j-1];
            }
        }
        // for(int[] ar: arr)
        // System.out.println(Arrays.toString(ar));
        return t - 2*arr[sum][n];
    }
}
