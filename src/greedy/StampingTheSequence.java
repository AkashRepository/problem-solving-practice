package greedy;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequence {

    private boolean check(String stamp, String target, int i, boolean[] arr) {
        for (int j = 0; j < stamp.length(); j++) {
            if (!arr[i + j] && stamp.charAt(j) != target.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    private void update(String stamp, String target, int i, boolean[] arr) {
        for (int j = 0; j < stamp.length(); j++) {
            arr[j + i] = true;
        }
    }

    public int[] movesToStamp(String stamp, String target) {
        int j = 0;
        int m = stamp.length();
        int n = target.length();
        int out = 0;
        boolean[] v = new boolean[n];
        boolean[] arr = new boolean[n];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (count < n) {

            boolean f = false;
            for (int i = 0; i < n - m + 1 && j < n; i++) {

                if (!v[i] && check(stamp, target, i, arr)) {
                    update(stamp, target, i, arr);
                    list.add(i);
                    v[i] = true;
                    f = true;
                }
            }
            if (!f) {
                return new int[]{};
            }
            count = 0;
            for (boolean a : arr) {
                if (a)
                    count++;
            }
        }

        j = 0;
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            res[j++] = list.get(i);
        }
        return res;
    }
}
