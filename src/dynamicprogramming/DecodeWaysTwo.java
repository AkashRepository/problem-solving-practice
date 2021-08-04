package dynamicprogramming;

public class DecodeWaysTwo {

    long MOD = 1_000_000_007;

    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        long[] arr = new long[n];
        int i = 0;

        if (n == 1) {
            if (c[0] == '*') {
                return 9;
            } else if (c[0] != '0') {
                return 1;
            }
            return 0;
        }
        if (c[0] == '0') {
            arr[0] = 0;
            arr[1] = 0;
        } else if (c[0] != '*' && c[1] != '*') {
            arr[0] = 1;

            int prev = c[0] - '0';
            int curr = c[1] - '0';

            if (curr >= 1 && curr <= 9) {
                arr[1] = arr[0];
            }
            int val = prev * 10 + curr;
            if (val >= 10 && val <= 26) {
                arr[1] = arr[1] + 1;
            }
        } else if (c[0] == '*' && c[1] != '*') {
            arr[0] = 9;
            int curr = c[1] - '0';

            if (curr >= 1 && curr <= 9) {
                arr[1] = arr[0];
            }
            for (int prev = 1; prev <= 9; prev++) {
                int val = prev * 10 + curr;
                if (val >= 10 && val <= 26) {
                    arr[1] = arr[1] + 1;
                }
            }
        } else if (c[0] != '*' && c[1] == '*') {
            arr[0] = 1;
            int prev = c[0] - '0';
            arr[1] = 9;
            for (int curr = 1; curr <= 9; curr++) {
                int val = prev * 10 + curr;
                if (val >= 10 && val <= 26) {
                    arr[1] = arr[1] + 1;
                }
            }
        } else if (c[0] == '*' && c[1] == '*') {
            int prev = 1;
            arr[0] = 9;
            arr[1] = 81;
            for (int curr = 1; curr <= 9; curr++) {
                int val = prev * 10 + curr;
                if (val >= 10 && val <= 26) {
                    arr[1] = arr[1] + 1;
                }
            }
            prev = 2;
            for (int curr = 1; curr <= 9; curr++) {
                int val = prev * 10 + curr;
                if (val >= 10 && val <= 26) {
                    arr[1] = arr[1] + 1;
                }
            }
        }

        for (i = 2; i < n; i++) {

            if (c[i - 1] != '*' && c[i] != '*') {
                int prev = c[i - 1] - '0';
                int curr = c[i] - '0';

                if (curr >= 1 && curr <= 9) {
                    arr[i] = arr[i - 1];
                }
                int val = prev * 10 + curr;
                if (val >= 10 && val <= 26) {
                    arr[i] = arr[i] + arr[i - 2];
                }
            } else if (c[i - 1] == '*' && c[i] != '*') {
                int curr = c[i] - '0';

                if (curr >= 1 && curr <= 9) {
                    arr[i] = arr[i - 1];
                }

                for (int prev = 1; prev <= 9; prev++) {
                    int val = prev * 10 + curr;
                    if (val >= 10 && val <= 26) {
                        arr[i] = arr[i] + arr[i - 2];
                    }
                }

            } else if (c[i - 1] != '*' && c[i] == '*') {
                arr[i] = arr[i - 1] * 9;
                int prev = c[i - 1] - '0';
                for (int curr = 1; curr <= 9; curr++) {
                    int val = prev * 10 + curr;
                    if (val >= 10 && val <= 26) {
                        arr[i] = arr[i] + arr[i - 2];
                    }
                }
            } else if (c[i - 1] == '*' && c[i] == '*') {
                arr[i] = arr[i - 1] * 9;
                int prev = 1;
                for (int curr = 1; curr <= 9; curr++) {
                    int val = prev * 10 + curr;
                    if (val >= 10 && val <= 26) {
                        arr[i] = arr[i] + arr[i - 2];
                    }
                }
                prev = 2;
                for (int curr = 1; curr <= 9; curr++) {
                    int val = prev * 10 + curr;
                    if (val >= 10 && val <= 26) {
                        arr[i] = arr[i] + arr[i - 2];
                    }
                }
            }
            arr[i] = arr[i] % MOD;
        }
        // System.out.println(Arrays.toString(arr));
        return (int) (arr[n - 1] % MOD);

    }
}
