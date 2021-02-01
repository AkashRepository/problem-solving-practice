import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinimumDeviationInArray {

    public int minimumDeviation(int[] nums) {
       int out = Integer.MAX_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int a: nums){
            if((a&1)==1){
                ts.add(a*2);
            } else {
                ts.add(a);
            }
        }
        boolean f = true;
        while(f){
            int min = ts.first();
            int max = ts.last();
            out = Math.min(out, max-min);
            if((max&1)==0){
                ts.remove(max);
                ts.add(max/2);
            } else {
                f = false;
            }
        }
       return out;
    }

    private int[] findMinMax(int[] nums) {
        int min = nums[0], max = nums[0];
        int mii = 0, mi = 0;
        int i = 0;
        Arrays.stream(nums).filter(a -> a!=0).findAny().isPresent();
        for (int a : nums) {
            if (a < min) {
                min = a;
                mii = i;
            }
            if (a > max) {
                mi = i;
                max = a;
            }
            i++;
        }
        return new int[]{min, max, mii, mi};
    }

    public static void main(String[] args) {
        MinimumDeviationInArray o = new MinimumDeviationInArray();
        System.out.println(o.minimumDeviation(new int[]{399,908,648,357,693,502,331,649,596,698}));
//        System.out.println(o.minimumDeviation(new int[]{3,5}));
    }
}
