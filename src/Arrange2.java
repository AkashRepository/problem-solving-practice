public class Arrange2 {

    public int arrange(String A, int B) {
        int n = A.length();
        if (n < B) {
            return -1;
        } else if (n == B) {
            return 0;
        }
        int[][] arr = new int[n][B];
        int w = 0, b = 0;
        for (int i = 0; i < n; i++) {
            w += A.charAt(i) == 'W' ? 1 : 0;
            b += A.charAt(i) == 'B' ? 1 : 0;
            arr[i][0] = w * b;
        }
        for (int k = 1; k < B; k++) {
            for (int i = 0; i < n; i++) {
                w = 0;
                b = 0;
                arr[i][k] = Integer.MAX_VALUE;
                for (int j = i; j >= 0; j--) {
                    w += A.charAt(j) == 'W' ? 1 : 0;
                    b += A.charAt(j) == 'B' ? 1 : 0;
                    arr[i][k] = Math.min(arr[i][k], w * b + (j != 0 ? arr[j - 1][k - 1] : 0));
                }
            }
        }
        return arr[n - 1][B - 1];
    }

}
