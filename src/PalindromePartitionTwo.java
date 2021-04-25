import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitionTwo {

    public static void main(String[] args) {
        PalindromePartitionTwo o = new PalindromePartitionTwo();
        System.out.println(o.minCut("bbab"));
        System.out.println(o.minCut("aab"));
        System.out.println(o.minCut("encwjoojdno"));
        System.out.println(o.minCut("bb"));
        System.out.println(o.minCut("bbab"));
        System.out.println(o.minCut("nweconocnencnnncnccncncn"));
//        System.out.println(o.partition("aab"));
//        System.out.println(o.partition("bbab"));

    }


    public List<List<String>> partition(String a) {
        List<List<String>> out = new ArrayList<>();
        min = Integer.MAX_VALUE;
        partitionHelper(a, new ArrayList<>(), out);
        return out;
    }

    private void partitionHelper(String a, List<String> arr, List<List<String>> out) {
        int n = a.length();
        if (n == 0) {
            out.add(new ArrayList<>(arr));
        }
        for (int i = 1; i <= n; i++) {
            String s = a.substring(0, i);
            if (isPalindrome(s)) {
                arr.add(s);
                partitionHelper(a.substring(i), arr, out);
                arr.remove(arr.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }


    public int minCut(String A) {

        int n = A.length();
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (A.charAt(i - 1) == A.charAt(i))
                arr[i - 1][i] = 2;
            arr[i][i] = 1;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = j + i - 1;
                if (A.charAt(j) == A.charAt(k) && arr[j + 1][k - 1] != 0) {
                    arr[j][k] = arr[j + 1][k - 1] + 2;
                }
            }
        }

        for (int[] p : arr) {
            System.out.println(Arrays.toString(p));
        }

//        backtrack(0, 0, n, arr, new ArrayList<>(), A);
        backtrack(n - 1, n, arr, 1);
        int[] value = new int[n];
        for (int i = 1; i < n; i++) {
            value[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j + 1][i]!=0 && value[i] > value[j] + 1) {
                    value[i] = value[j] + 1;
                }
            }

        }
        System.out.println(Arrays.toString(value));
//        System.out.println(out);
        System.out.println("min:" + min);
        return 0;
//        return value[n - 1];
    }

    List<List<String>> out = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    private void backtrack(int j, int n, int[][] arr, int out) {
        if (j == -1) {
            min = Math.min(min, out - 1);
            return;
        }
        if (j < 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int mi = -1;
        for (int ii = 0; ii < n; ii++) {
            if (arr[ii][j] > max) {
                max = arr[ii][j];
                mi = ii;
            }
        }
        backtrack(mi - 1, n, arr, out + 1);
    }

    private void backtrack(int i, int j, int n, boolean[][] arr, List<String> a, String s) {
        if (j == n) {
            out.add(new ArrayList<>(a));
            return;
        }
        if (i >= n)
            return;

        for (int jj = j; jj < n; jj++) {
            if (arr[i][jj]) {
                a.add(s.substring(i, jj + 1));
                for (int ii = i + 1; ii <= n; ii++) {
                    backtrack(ii, jj + 1, n, arr, a, s);
                }
                a.remove(a.size() - 1);
            }
        }

    }
}
