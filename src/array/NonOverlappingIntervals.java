package array;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        NonOverlappingIntervals o = new NonOverlappingIntervals();
        o.compareVersion("01", "1");
    }

    public int compareVersion(String A, String B) {
        String[] aa = A.split("\\.");
        String[] bb = B.split("\\.");

        int n = aa.length;
        int m = bb.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            int idx1 = 0;
            while(idx1< aa[i].length() && aa[i].charAt(idx1)=='0'){
                idx1++;
            }
            int idx2 = 0;
            while(idx2< bb.length && bb[j].charAt(idx2)=='0'){
                idx2++;
            }
            while(idx1< aa[i].length() && idx2< bb[j].length()){
                if (aa[i].charAt(idx1) > aa[j].charAt(idx2)) {
                    return 1;
                } else if (aa[i].charAt(idx1) < aa[j].charAt(idx2)) {
                    return -1;
                }
                idx1++;
                idx2++;
            }

            i++;
            j++;
        }
        if(i==n && j!=m)
            return -1;
        if(i!=n && j==m)
            return 1;
        return 0;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] prev = intervals[0];
        int j = 1;
        int out = 0;
        while (j < n) {
            if (intervals[j][0] < prev[1]) {
                out++;
                intervals[j][1] = Math.min(intervals[j][1], prev[1]);
            }
            prev = intervals[j];
            j++;
        }
        return out;
    }
}
