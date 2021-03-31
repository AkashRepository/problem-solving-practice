package dynamicprogramming;

import java.util.Arrays;

public class RussianDolls {

    public static void main(String[] args) {
        RussianDolls o  = new RussianDolls();
        o.maxEnvelopes(new int[][]{{5,7},{9,10},{8,11},{11,13},{16,17},{14,19}});
    }

    public int maxEnvelopes(int[][] arr) {
        final int n = arr.length;
        Arrays.sort(arr, (o1, o2)->
                (o1[0]==o2[0]) ? Integer.compare(o2[1], o1[1]) :
                        Integer.compare(o1[0], o2[0]));

        int[] tmp = new int[n];
        for(int i=0; i<n; i++) tmp[i] = arr[i][1];

        return lengthOfLIS(tmp);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
