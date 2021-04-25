package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubMatrixTargetSum {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = matrix[i][j];
                } else if (j == 0) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j];
                } else if (i == 0) {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1];
                } else {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
                }
            }
        }
        // for(int[] ar: sum){
        //     System.out.println(Arrays.toString(ar));
        // }

        Map<Integer, Integer> map = new HashMap<>();
        int out = 0;
        for (int l = 1; l <= m; l++) { //l is for length of sliding window
            for (int startRow = 0; startRow <= m - l; startRow++) {
                map = new HashMap<>();
                map.put(0, 1);
                for (int col = 0; col < n; col++) {
                    int value = sum[startRow + l - 1][col] - (startRow != 0 ? sum[startRow - 1][col] : 0);
                    if (map.containsKey(value - target)) {
                        out = out + map.get(value - target);
                        // System.out.println("startRow: "+(startRow+l-1)+" end :"+end +" prevstart : "+(startRow-1));
                    }
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }
            }
        }
        return out;
    }
}
