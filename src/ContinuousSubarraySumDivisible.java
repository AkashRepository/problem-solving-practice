import java.util.Optional;

public class ContinuousSubarraySumDivisible {
    public boolean checkSubarraySum(int[] nums, int k) throws Exception{
        int n = nums.length;
        if (n == 1)
            return false;
        if (k == 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                min = Math.min(min, nums[i] + nums[i - 1]);
            }
            if (min == 0)
                return true;
            return false;
        }

        int[] arr = new int[n];
        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int b = 0;
                if((j - i - 1) >= 0 && (j - i - 1) < n)
                    b = arr[j - i - 1];
                int a = arr[j] - b;
                if (a % k == 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        ContinuousSubarraySumDivisible o = new ContinuousSubarraySumDivisible();
        System.out.println(o.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }
}
