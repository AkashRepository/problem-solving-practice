package array;

public class maximumProductLength {

    public int getMaxLen(int[] nums) {
        int first = -1;
        int start = -1;
        int last = -1;
        int count = 0;
        int out = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];

            if (a < 0) {
                if (first == -1) {
                    first = i;
                }
                if (start == -1) {
                    start = i;
                }
                last = i;
                count++;
            } else if (a == 0) {
                if (count % 2 == 0 && start != -1) {
                    out = Math.max(out, i - 1 - start + 1);
                } else if (first != -1 && start != -1) {
                    out = Math.max(out, Math.max(i - 1 - first, last - start));
                }
                start = -1;
                first = -1;
                last = -1;
                count = 0;
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (count % 2 == 0 && start != -1) {
            out = Math.max(out, n - start);
        } else if (first != -1) {
            out = Math.max(out, Math.max(n - 1 - first, last - start));
        }
        return out;
    }
}
