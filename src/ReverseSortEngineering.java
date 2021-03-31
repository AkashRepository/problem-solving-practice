import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseSortEngineering {

    private static void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    private static int calc(int[] arr, int n) {
        int out = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minidx = -1;
            for (int j = i; j <=n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minidx = j;
                }
            }
            out = out + minidx - i + 1;
            reverse(arr, i, minidx);
        }
        System.out.println(out);
        return out;
    }

    private static void traverse(int i, int n, int[] arr, int out, String[] f) {
        if (f[0] != null)
            return;
        if (i == n) {
            if (calc(arr, n) == out) {
//            System.out.println(Arrays.toString(arr));
//                System.out.println("asdasd");
                StringBuilder str = new StringBuilder();
                for (int a : arr) {
                    str.append(" ").append(a);
                }
                f[0] = str.toString().trim();
                return;
            }
        }
        for (int j = i; j <= n; j++) {
            swap(arr, i, j);
            traverse(i + 1, n, arr, out, f);
            swap(arr, i, j);
            if (f[0] != null)
                return;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        int t = 1;
        while (t <= tc) {
            String[] arrStr = br.readLine().trim().split(" ");

            int n = Integer.parseInt(arrStr[0]);
            int value = Integer.parseInt(arrStr[1]);

            int[] arr = new int[n];
            String out = "IMPOSSIBLE";
            String[] f = new String[1];
            for (int i = 0; i < n; i++)
                arr[i] = i + 1;
            traverse(0, n-1, arr, value, f);
            if (f[0] != null) {
                out = f[0];

            }
            System.out.println("Case #" + t + ": " + out);
            t++;
        }
        br.close();
    }
}