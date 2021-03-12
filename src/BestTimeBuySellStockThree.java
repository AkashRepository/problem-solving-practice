public class BestTimeBuySellStockThree {

    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }


        int[][] arr = new int[prices.length][2];
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            arr[i][0] = Math.max(arr[i-1][0], prices[i] - min);
        }
        int max = prices[prices.length-1];
        for(int i=arr.length-2;i>=0;i--){
            max = Math.max(max, prices[i]);
            arr[i][1] = Math.max(arr[i+1][1], max - prices[i]);
        }
        max  = 0;
        for(int[] a: arr){
            max = Math.max(a[0]+a[1],max);
        }
        return max;
    }
}
