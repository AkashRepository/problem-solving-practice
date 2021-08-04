package binarysearch;

import java.util.Arrays;

public class KthSmallestElementFromMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = matrix[0][0];
        int end = matrix[m - 1][n - 1];
        int mid, smallerThanMid;
        while (start <= end) {
            mid = (start + end) / 2;
            smallerThanMid = 0;
            for (int i = 0; i < m; i++) {
                int idx = Arrays.binarySearch(matrix[i], mid);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                smallerThanMid = smallerThanMid + idx;
            }
            if (smallerThanMid < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
