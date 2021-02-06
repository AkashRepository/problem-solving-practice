import java.lang.reflect.Array;
import java.util.Arrays;

public class WiggleSort2 {

    public static void main(String[] args) {
        WiggleSort2 o = new WiggleSort2();
        o.wiggleSort(new int[]{1,2,3,4,5,6});
        o.wiggleSort(new int[]{1,2,3,4,5,6,7,8,9,10});
    }

    public void wiggleSort(int[] nums) {
        int i = (nums.length / 2) - 1, j = nums.length - 1;
        int k = i+1;
        while (i < j) {
            swap(nums, i, j);
            System.out.println(Arrays.toString(nums));
            i--;
            j--;
            if(k>j){
                k = i+2;
            }
            swap(nums, k, j);
            System.out.println(Arrays.toString(nums));
            k++;
            j--;
        }
        System.out.println(Arrays.toString(nums));
//        j = (nums.length / 2) - 1;
//        i = 0;
//        while (i+1 < j) {
//            swap(nums, i, i + 1);
//            i=i+2;
//        }
//        System.out.println(Arrays.toString(nums));
    }
//  1 2 3 4 10 6 7 8 9 5
//  1 2 3 4 10 9 7 8 6 5
//  1 2 3 8 10 9 7 4 6 5
//  1 2 9 8 10 3 7 4 6 5
//  10 2
    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
}
