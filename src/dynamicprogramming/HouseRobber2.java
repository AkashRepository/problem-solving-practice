package dynamicprogramming;

public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1)
            return nums[0]; // incase size if 1

        int[] nums2 = nums.clone();

        nums[1] = Math.max(nums[0], nums[1]);

        if(n<=2)
            return nums[1]; // incase of size is 2

        for(int i=2;i<n-1;i++){
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        }
        int max = nums[n - 2]; // maximum from 0 to n-1

        nums2[2] = Math.max(nums2[1], nums2[2]);

        for(int i=3;i<n;i++){
            nums2[i] = Math.max(nums2[i-1], nums2[i-2]+nums2[i]);
        }

        max = Math.max(max, nums2[n-1]); // max of 0 to n-1 , 1 to n
        return max;
    }
}
