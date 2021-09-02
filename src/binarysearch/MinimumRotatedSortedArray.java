package binarysearch;

import java.util.Arrays;

public class MinimumRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = nums.length;
        int s = 0;
        return binarySearch(s, l - 1, nums);
    }

    public int binarySearch(int s, int l, int[] nums) {

        while (s <= l) {
            int m = (l + s) / 2;
            if (s == l) {
                return nums[s];
            }
            if (s == l - 1) {
                return Math.min(nums[s], nums[l]);
            }
            if (nums[s] > nums[m]) {
                l = m;
            } else if (nums[l] < nums[m]) {
                s = m;
            } else {
                return nums[0];
            }
        }
        return l;

    }


    public static void main(String[] args) {
        MinimumRotatedSortedArray o = new MinimumRotatedSortedArray();
        System.out.println(Arrays.toString(",2,null,4,45,null".split(",")));
        int i = 0;
        func(i++);
//        System.out.println(o.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    public static void func(int i){
        System.out.println(i);
    }
}
