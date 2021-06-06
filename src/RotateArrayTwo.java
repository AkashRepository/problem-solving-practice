import java.util.Arrays;

public class RotateArrayTwo {


    public static void main(String[] args) {
        RotateArrayTwo o = new RotateArrayTwo();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        o.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        // 5 6 7 4 1 2 3
        // 5 6 7 1 2 3 4
        int n = nums.length;
        int i = 0, j = n - k;

        while (i < n) {
            int t = k;
            while (t-- > 0 && i < n && j < n) {
                swap(i, j, nums);
                i++;
                j++;
            }
            n = n - k;
            j = nums.length - k;
        }

    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
