import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortIntegerByPowerValues {

    public static void main(String[] args) {
        SortIntegerByPowerValues o = new SortIntegerByPowerValues();
//        System.out.println(o.getKth(12, 15, 2));
        System.out.println(o.getKth(18, 32, 10));
//        System.out.println(o.getKth(1, 1, 1));
//        System.out.println(o.getKth(7, 11, 4));
//        System.out.println(o.getKth(7, 11, 4));
    }

    private int getPower(int i, Map<Integer, Integer> m) {
        if (m.containsKey(i)) {
            return m.get(i);
        }
        if (i % 2 == 0) {
            if (i != 0 && (i & (i - 1)) == 0) {
                int t = 0;
                int ii = i;
                while (ii != 1) {
                    ii = ii / 2;
                    t++;
                }
                m.put(i, t);
                return t;
            }
            int val = getPower(i / 2, m) + 1;
            m.put(i, val);
            return val;
        }
        int val = getPower(3 * i + 1, m) + 1;
        m.put(i, val);
        return val;
    }

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int[][] arr = new int[hi-lo+1][2];
        int t = 0;
        for (int i = lo; i <= hi; i++) {
            arr[t][1] = getPower(i, m);
            arr[t++][0] = i;
        }
        Arrays.sort(arr, (a,b) -> {
            if(a[1]==b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        return arr[k-1][0];
    }
}
