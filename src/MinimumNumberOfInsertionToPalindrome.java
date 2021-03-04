import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberOfInsertionToPalindrome {

    public static void main(String[] args) {
        MinimumNumberOfInsertionToPalindrome o = new MinimumNumberOfInsertionToPalindrome();
        System.out.println(o.minInsertions("zzazz"));
        System.out.println(o.minInsertions("mbadm"));
        System.out.println(o.minInsertions("leetcode"));
    }


    public int minInsertions(String s) {

        int n = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i][i] = 1;
            arr[i-1][i] = s.charAt(i-1) == s.charAt(i) ? 2 : Math.max(arr[i][i], arr[i][i-1]);
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
                }
            }
        }
        return n - arr[0][n-1];

    }
}
