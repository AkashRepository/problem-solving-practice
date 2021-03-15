package array;

import java.util.TreeMap;

public class DivideArrayInK {

    public static void main(String[] args) {
        DivideArrayInK o = new DivideArrayInK();
        System.out.println(o.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
    }

    public boolean isPossibleDivide(int[] nums, int k) {


        int n = nums.length;
        if (n % k != 0)
            return false;

        int v = n / k;
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int a : nums) {
            m.put(a, m.getOrDefault(a, 0) + 1);
        }
        int out = 0;
        for (Integer i : m.keySet()) {
            while (m.get(i) > 0){
                for (int ii = 0; ii < k; ii++) {
                    if (m.get(i + ii) == null || m.get(i + ii) <= 0 || m.get(i + ii) > v) {
                        return false;
                    } else {
                        m.put(i + ii, m.get(i + ii) - 1);
                        out++;
                    }
                }
            }
        }

        return out == n;
    }
}
