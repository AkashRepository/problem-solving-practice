import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        arr[0][0] = triangle.get(0).get(0);

        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    arr[i][j] = arr[i-1][j] + triangle.get(i).get(j);
                } else {
                    arr[i][j] = Math.min(arr[i-1][j-1], arr[i-1][j]) + triangle.get(i).get(j);
                }

                if(i==n-1){
                    min = Math.min(min, arr[i][j]);
                }
            }
        }
        // for(int[] a: arr)
        //     System.out.println(Arrays.toString(a));
        return min==Integer.MAX_VALUE?arr[0][0]:min;

    }
}
