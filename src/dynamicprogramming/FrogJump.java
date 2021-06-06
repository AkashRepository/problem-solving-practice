package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    public static void main(String[] args) {
        FrogJump o = new FrogJump();
        System.out.println(o.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        Set<String> dp = new HashSet<>();
        return jump(1, 1, stones, dp);

    }

    private boolean jump(int idx, int prev, int[] stones, Set<String> dp) {

        if (idx == stones.length - 1)
            return true;
        if (dp.contains(idx + "-" + prev))
            return false;

        for (int j = idx + 1; j < stones.length; j++) {
            if(stones[j]>stones[idx]+prev+1){
                break;
            }
            if(stones[j]==stones[idx]+prev){
                if (jump(j, prev, stones, dp))
                    return true;
            }

            if(stones[j]==stones[idx]+prev-1){
                if (jump(j, prev-1, stones, dp))
                    return true;
            }

            if(stones[j]==stones[idx]+prev+1){
                if (jump(j, prev+1, stones, dp))
                    return true;
            }
        }
        dp.add(idx + "-" + prev);
        return false;
    }
}
