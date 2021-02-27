import java.util.Arrays;

public class PalindromePartition2 {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return "".hashCode();
    }

    public static void main(String[] args) {
        PalindromePartition2 o = new PalindromePartition2();
        System.out.println(o.minCut("aab"));
        System.out.println(o.minCut("bbab"));
    }


    public int minCut(String A) {

        int n = A.length();
        boolean[][] arr = new boolean[n][n];
        arr[0][0] = true;
        for (int i = 1; i < n; i++) {
            if (A.charAt(i - 1) == A.charAt(i))
                arr[i - 1][i] = true;
            arr[i][i] = true;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = j + i - 1;
                if (A.charAt(j) == A.charAt(k) && arr[j + 1][k - 1]) {
                    arr[j][k] = true;
                }
            }
        }

        for(boolean[] p : arr){
            System.out.println(Arrays.toString(p));
        }
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[0][i])
                value[i] = 0;
            else {
                value[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (arr[j + 1][i] && value[i] > value[j] + 1) {
                        value[i] = value[j] + 1;
                    }
                }
            }

        }
        return value[n - 1];
    }
}
