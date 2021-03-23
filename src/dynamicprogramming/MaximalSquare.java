package dynamicprogramming;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                max = 1;
                arr[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                max = 1;
                arr[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int a = arr[i - 1][j - 1];
                    int b = arr[i - 1][j];
                    int c = arr[i][j - 1];
                    int d = Math.min(Math.min(a, b), c);
                    arr[i][j] = d + 1;
                    max = Math.max(arr[i][j], max);
                }

            }
            // for(int[] ar: arr)
            //     System.out.println(Arrays.toString(ar));
        }
        return max * max;
    }
}
