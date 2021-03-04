import java.util.ArrayList;

public class SumOfPathRightTriangle {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,5,7}; //1 2 3 4 5 6 7  5 6
        int n =nums.length;
        int out = nums[0];
        int i=1;
        for(i=1;i<n;i++){
            out = out ^ i ^ nums[i];
            System.out.println(out);
        }
        i = i ^ n;
//        for (int num : nums) {
//            out = out ^ num;
//        }

        System.out.println( i);
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = A.get(i).get(j);
                if (i == 0 && j == 0)
                    continue;
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j];
                } else {
                    arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                }

            }
        }
        int max = arr[0][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[n - 1][i]);
        }
        return max;
    }
}
