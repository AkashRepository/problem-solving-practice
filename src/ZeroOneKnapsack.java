import java.util.ArrayList;

public class ZeroOneKnapsack {

        public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
            int n = A.size();
            int[][] arr =new int[n+1][C+1];


            for(int i=1;i<=n;i++){
                for(int j=1;j<=C;j++){

                    if(B.get(i-1)<=j){
                        arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-B.get(i-1)]+A.get(i-1));
                    } else {
                        arr[i][j] = arr[i-1][j];
                    }

                }
            }
            return arr[n][C];

    }
}
