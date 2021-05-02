package greedy;

import java.util.Arrays;

public class MaximumConsecutiveValuesMake {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int max = 0;
        for(int i=0;i<n;i++){
            int a = coins[i];
            if(a<=max+1){
                max = max + a;
            } else {
                break;
            }
        }
        return max+1;
    }
}
