import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NarrowArtGallery {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[][] g = new int[n][2];
            int total = 0;
            for (int i = 0; i < n; i++) {
                String[] v = br.readLine().split(" ");
                g[i][0] = Integer.parseInt(v[0]);
                g[i][1] = Integer.parseInt(v[1]);
                total+=g[i][0]+g[i][1];
            }

            int[][][] arr = new int[k+1][n][2];

            for(int i=1;i<=k;i++) {
                for (int j = 0; j < n; j++) {
                    if(i==1){
                        arr[1][j][0]=g[j][0];
                        arr[1][j][1]=g[j][1];
                    }
                    if(i > j +1){
                        arr[i][j][0]=Integer.MAX_VALUE;
                        arr[i][j][1]=Integer.MAX_VALUE;
                    }
                }
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j < n;j++){
                    if(i > j + 1)
                        continue;
                    arr[i][j][0] = Math.min(arr[i-1][j-1][0] + g[j][0], Math.min(arr[i][j-1][0],
                            arr[i][j-1][1]));

                    arr[i][j][1] = Math.min(arr[i-1][j-1][1] + g[j][1], Math.min(arr[i][j-1][0],
                            arr[i][j-1][1]));
                }
            }
            System.out.println(total - Math.min(arr[k][n-1][0], arr[k][n-1][1]));
//            System.out.println(total - Math.min(best(k, n-1, 0, g, arr), best(k, n-1, 1, g, arr))); //TLE

        }

    }

    private static int best(int k, int n, int i, int[][] g, int[][][] arr) {
        if (k == 0) {
            return 0;
        }
        if(k > n+1){
            return Integer.MAX_VALUE;
        }
        if(n<0)
            return Integer.MAX_VALUE;
        if(arr[k][n][i]!=0){
            return arr[k][n][i];
        }

        int min = (n-1)>=0?best(k - 1, n - 1, i, g, arr) + g[n][i] : g[n][i];
        if((n-1)>=0)
            min = Math.min(min, Math.min(best(k, n - 1, 0, g, arr), best(k, n - 1, 1, g, arr)));
        arr[k][n][i] = min;
        return arr[k][n][i];
    }
}
