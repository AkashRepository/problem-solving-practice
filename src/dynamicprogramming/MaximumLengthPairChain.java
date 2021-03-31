package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

public class MaximumLengthPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b) -> a[0]-b[0]);
        int n = pairs.length;
        int out = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=1;
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1] && arr[i]<arr[j]+1){
                    arr[i]=arr[j]+1;
                }
                out=Math.max(out, arr[i]);
            }
        }
        return out;
    }
}
