package binarysearch;

public class MinimumNumberOfDaysMBouquets {


    private boolean isValid(int[] arr, int m, int k, int mid) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (m <= 0)
                break;
            if (arr[i] > mid) {
                start = i + 1;
            }
            if (i - start + 1 == k) {
                m--;
                start = i + 1;
            }
        }

        return m <= 0;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int out = 0;
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        int min = bloomDay[0];
        int max = min;

        for (int a : bloomDay) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int low = min, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(bloomDay, m, k, mid)) {
                out = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return out;
    }
}
