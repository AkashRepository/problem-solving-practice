public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][][] arr =new int[size+1][m+1][n+1];

        int[][] a = new int[size][2];
        for(int i=0;i<size;i++){
            int o=0, z=0;
            for(char c: strs[i].toCharArray()){
                if(c=='1')
                    o=o+1;
                else
                    z=z+1;
            }
            a[i][0]=z;
            a[i][1]=o;
        }
        int out = 0;
        for(int i=1;i<=size;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int zero = a[i-1][0];
                    int one = a[i-1][1];
                    if(zero<=j && one<=k){
                        arr[i][j][k] = Math.max(arr[i-1][j][k], arr[i-1][j-zero][k-one]+1);
                    } else {
                        arr[i][j][k] = arr[i-1][j][k];
                    }

                    out = Math.max(out, arr[i][j][k]);
                }
            }
        }
        return out;
    }
}
