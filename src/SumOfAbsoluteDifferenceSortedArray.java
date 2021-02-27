import java.util.Arrays;

public class SumOfAbsoluteDifferenceSortedArray {

    /**
     As the given array is sorted in ascending order. For sum of absolute difference we have to calculate for an index (ith index), the left side and right side of the array.
     Because all the number on left side will be smaller.

     So, |a-b| where a < b. we get -(a-b) and summation will be something like -a1-a2-a3-a4...+b+b+b . So -(sum from left) + i times b.

     Similarly for right side, where a is greater than b. |a-b| we will get a-b. and summation as a1+a2+a3+a4+a5....-b-b-b-b-b... which is (sum from right side OR totalSum - sum of left side - current element) - (n-1-i) times b.
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] out = new int[nums.length];
        int n =nums.length;
        int sumSoFar = 0;
        int totalSum = Arrays.stream(nums).sum();
        for(int i=0;i<nums.length;i++){
            int less = (i-0)*nums[i];
            less = less - sumSoFar;

            int greater = (n-1-i)*nums[i];
            greater = (totalSum - sumSoFar - nums[i]) - greater; // sum from right

            sumSoFar = sumSoFar + nums[i]; // sum from left
            out[i] = less + greater;
        }
        return out;

    }
}
