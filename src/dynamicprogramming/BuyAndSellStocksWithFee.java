package dynamicprogramming;

public class BuyAndSellStocksWithFee {

    public int maxProfitNaive(int[] prices, int fee) {

        int n = prices.length;
        int[] arr = new int[n];
        int b=0, s=0;
        b = Math.max(b, prices[0]);
        for(int i=1;i<n;i++){ // we will consider ith index for selling and jth index for buying stocks

            arr[i] = arr[i-1];
            for(int j=0;j<i;j++){ // for all the previous values when we could have bought the
                // stocks. Best profit = Max(currentProfit + previous profit(arr[j-1])).
                int currentProfit = prices[i] - prices[j] - fee;
                if(j>=1)
                    arr[i] = Math.max(arr[i],arr[j-1] + currentProfit);
                else {
                    arr[i] = Math.max(arr[i],currentProfit);
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        return arr[n-1];

    }

    //From the above solution which runs in O(N^2) . We can reduce the second iteration as
    // is being computed again and again.
    // Explanation :
  /*
  Recurrence relation :
  T(i) = Max( prices[i] - prices[j] - fee + T(j-1)) for all j= 0 to i-1;

  We are computing T(i) = Max(prices[i] - prices[0] - fee + T(-1) , prices[i] - prices[1] - fee + T(0), prices[i] - prices[2] - fee + T(1), ... , prices[i] - prices[i-1] - fee + T(i-2));
  so, we can re write this as, T(i) = prices[i] + Max(T(-1) - prices[0] +
													  T(0) - prices[1] +
													  T(1) - prices[2] +
													  ... - fee)
let T(i) = s, so s = Max( s , prices[i] + previousB); where previousB = Max( previousB , previousS - prices[i-1] - fee);
  */


    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int b=0, s=0;
        b = -1*prices[0] - fee; //initially we need to buy, b = T(-1) - prices[0] - fee where T(-1) = 0
        for(int i=1;i<n;i++){
            int prevB = b;
            b = Math.max(b, s - prices[i] - fee);
            s = Math.max(s, prices[i] + prevB);

        }
        return s;

    }

}
