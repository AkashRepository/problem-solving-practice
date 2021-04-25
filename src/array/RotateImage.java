package array;

public class RotateImage {

    public void rotate(int[][] arr) {
        int n = arr.length;
        int len = (int)Math.ceil(n/2);
        for(int i=0;i<len;i++){
            for(int j=i;j<n-i-1;j++){

                int a = arr[i][j];
                int t = arr[j][n-1-i];
                arr[j][n-1-i] = a;
                a = t;

                t = arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j] = a;
                a = t;

                t = arr[n-1-j][i];
                arr[n-1-j][i] = a;
                a = t;

                t = arr[i][j];
                arr[i][j] = a;
            }

        }
    }
}
