import java.util.*;

public class MaximumArrayFromTwoArray {

    private ArrayDeque<Integer> search(int[] nums, int diff) {

        ArrayDeque<Integer> arr1 = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            while (diff > 0 && !arr1.isEmpty() && arr1.peekLast() < max) {
                arr1.removeLast();
                diff--;
            }
            arr1.addLast(max);
        }
        return arr1;
    }

    private int[] merge(ArrayDeque<Integer> arr1, ArrayDeque<Integer> arr2, int k) {
        int i = 0, x = 0, y = 0;
        int[] out = new int[k];
        Integer[] ar = arr1.toArray(new Integer[0]);
        Integer[] br = arr2.toArray(new Integer[0]);
        while (i != k && x < ar.length && y < br.length) {
            int a = ar[x];
            int b = br[y];
            if (a > b) {
                out[i++] = a;
                x++;
            } else if(a==b){
                int xt = x+1, yt = y+1;
                while(a==b && xt < ar.length && yt < br.length){
                    a = ar[xt++];
                    b = br[yt++];
                }
                while(a==b && xt < ar.length){
                    a = ar[xt++];
                }

                while(a==b && yt < br.length){
                    b = br[yt++];
                }
                if(a < b){
                    out[i++] = br[y];
                    y++;
                } else {
                    out[i++] = ar[x];
                    x++;
                }
            } else {
                out[i++] = b;
                y++;
            }
        }
        while (i != k && x < ar.length) {
            int a = ar[x++];
            out[i++] = a;
        }
        while (i != k && y < br.length) {
            int a = br[y++];
            out[i++] = a;
        }
        return out;
    }

    private int[] compare(int[] t, int[] prev) {
        if (prev == null)
            return t;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > prev[i]) {
                return t;
            } else if (t[i] < prev[i]) {
                return prev;
            }
        }
        return t;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int diff = nums1.length + nums2.length - k;
        int[] prev = null;
        for (int i = 0; i <= diff; i++) {
            ArrayDeque<Integer> arr1 = search(nums1, i);
            ArrayDeque<Integer> arr2 = search(nums2, diff - i);
            int[] t = merge(arr1, arr2, k);
            prev = compare(t, prev);
        }
        PriorityQueue<Integer> p = new PriorityQueue<>();
        return prev;
    }


    public static void main(String[] args) {
        MaximumArrayFromTwoArray o = new MaximumArrayFromTwoArray();
        System.out.println(Arrays.toString(o.maxNumber(new int[]{6, 7},
                new int[]{6, 0, 4}
                , 5)));
        System.out.println(Arrays.toString(o.maxNumber(new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}
