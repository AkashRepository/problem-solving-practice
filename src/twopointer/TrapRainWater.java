package twopointer;

import java.util.Arrays;
import java.util.List;

public class TrapRainWater {

    public static void main(String[] args) {
        TrapRainWater o = new TrapRainWater();
        System.out.println(o.trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(o.trap(Arrays.asList(0, 1, 0, 2, 0, 4)));
    }

    public int trap(final List<Integer> A) {
        int out = 0;

        int i = 0, j = A.size() - 1;
        int local_max1 = 0;
        int local_max2 = 0;
        while (i < j) {
            int a = A.get(i);
            int b = A.get(j);

            if (a < b) {
                local_max1 = Math.max(local_max1, a);
                out = out + local_max1 - a;
                i++;
            } else {
                local_max2 = Math.max(local_max2, b);
                out = out + local_max2 - b;
                j--;
            }
        }
        return out;
    }
}
