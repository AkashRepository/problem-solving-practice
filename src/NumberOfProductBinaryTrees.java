import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfProductBinaryTrees {

    private final int MOD = 1_000_000_007;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> m = new HashMap<>();
        int n = arr.length;
        // int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            m.put(arr[i],1L);
        }

        int sum = 0;
        for(int i=1;i<n;i++){
            long s = 1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int val = arr[i]/arr[j];
                    s = (s + (m.getOrDefault(val, 0L)*m.getOrDefault(arr[j],0L))%MOD)%MOD;
                }
            }
            m.put(arr[i], s%MOD);
            sum = (int) ((sum + s%MOD)%MOD);
        }
        return (sum+1)%MOD;
    }


}
