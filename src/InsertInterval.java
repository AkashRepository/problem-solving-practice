import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval o = new InsertInterval();

        for (int[] a : o.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] insert(int[][] intervals, int[] newI) {
        if (intervals.length == 0)
            return new int[][]{newI};

        List<int[]> l = new ArrayList<>();
        for (int a[] : intervals) {
            if (newI[1] < a[0]) {
                l.add(newI);
                newI = a;
            } else if (a[1] < newI[0]) {
                l.add(a);
            } else {
                newI[0] = Math.min(a[0], newI[0]);
                newI[1] = Math.max(a[1], newI[1]);
            }
        }
        l.add(newI);
        int[][] out = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            out[i] = l.get(i);
        }
        return out;
    }
}
