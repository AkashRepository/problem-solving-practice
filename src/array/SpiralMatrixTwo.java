package array;

import java.util.Arrays;

public class SpiralMatrixTwo {

    public static void main(String[] args) {
        SpiralMatrixTwo o = new SpiralMatrixTwo();
        Arrays.stream(o.generateMatrix(4)).map(Arrays::toString).forEach(System.out::println);
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int loop = (n+1)/2;
        int c = 1;
        for(int x = 0;x<loop && c<=(n*n);x++){

            for(int i=x;i<n-x && c<=(n*n);i++){
                arr[x][i] = c++;
            }

            for(int i=x+1;i<n-x && c<=(n*n);i++){
                arr[i][n-1-x] = c++;
            }

            for(int i=n-2-x;i>=x && c<=(n*n);i--){
                arr[n-1-x][i] = c++;
            }

            for(int i=n-2-x;i>=x+1 && c<=(n*n);i--){
                arr[i][x] = c++;
            }
        }
        return arr;
    }
}
