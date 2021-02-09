import java.util.ArrayList;
import java.util.Iterator;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray o =new RotateArray();
        System.out.println(o.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}
        ,2));
    }

    public int search(int[] nums, int B) {
        int last = nums.length - 1;
        int a = 0, b = last;

        //Find the place where rotation is happening
        while (a < b) {
            int mid = (a + b) / 2;
            if (nums[mid] > nums[b]) {
                a = mid;
            } else {
                b = mid;
            }
            if (a == b - 1) {
                break;
            }
        }
        // If no rotation
        if (nums[a] <= nums[b]) {
            if (B <= nums[last]) {
                return bsearch(nums, 0, last, B);
            }
        } else { //with rotation and a index is maximum
            if (B <= nums[a]) {
                if (B >= nums[0])
                    return bsearch(nums, 0, a, B);
                else
                    return bsearch(nums, a + 1, last, B);
            }
        }

        return -1;
    }

    private int bsearch(int[] nums, int i, int j, int B) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (B == nums[mid])
                return mid;
            else if (B < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;

    }
}
