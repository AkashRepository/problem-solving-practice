package dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int t = nums[i];
            nums[i] = nums[i-1];
            nums[i] = Math.max(nums[i], nums[i-2] + t);
        }
        return nums[n-1];
    }
}