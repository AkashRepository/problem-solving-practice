package array;

import java.util.Arrays;

public class MinimumMovesToMakeEqualArray {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int out = 0, c = 0;
        int mid = (n & 1) == 0 ? (nums[n / 2 - 1] + nums[n / 2]) / 2 : nums[n / 2];
        for (int a : nums) {
            out = out + Math.abs(mid - a);
        }
        return out;
    }
}
