package greedy;

import java.util.Arrays;
import java.util.List;

public class GasStation {

    public static void main(String[] args) {
        GasStation o = new GasStation();
        System.out.println(o.canCompleteCircuit(Arrays.asList(1,2), Arrays.asList(2,1)));
    }

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int start = 0;
        int prev = 0;
        int idx = 0;
        for (int i = 0; i < n && start < n; i++) {
            prev = prev + A.get(idx) - B.get(idx);
            if (prev < 0) {

                idx = start;
                start++;
                i = -1;
                prev = 0;
            }
            if (idx >= n - 1) {
                idx = 0;
            } else {
                idx++;
            }
        }
        return start == n ? -1 : start;
    }


}