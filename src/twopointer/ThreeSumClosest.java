package twopointer;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // sort the array in non-desc order
        //so that we can check with two pointer method whether the sum is target - nums[a] = nums[b] + nums[c]
        int value = Integer.MAX_VALUE;
        int out = 0;
        for (int a = 0; a < n; a++) {
            int b = a + 1;
            int c = n - 1;
            while (b < c) {
                if (value > Math.abs(nums[a] + nums[b] + nums[c] - target)) {
                    value = Math.abs(nums[a] + nums[b] + nums[c] - target);
                    out = nums[a] + nums[b] + nums[c];
                }
                if (nums[a] + nums[b] + nums[c] == target) { // if equal so just return because
                    //we can not get any further than zero
                    return nums[a] + nums[b] + nums[c];
                } else if (nums[a] + nums[b] + nums[c] < target) {
                    b++; // target is more than move leftmost pointer to right side with higher values
                } else {
                    c--;
                }
            }
        }
        return out;
    }

}
