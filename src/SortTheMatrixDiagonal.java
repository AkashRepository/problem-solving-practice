import java.util.Arrays;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonal {

    public int[][] diagonalSortBySort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Integer[] arr = new Integer[m+n];

        int i = 0;
        int r = -1;
        int c = -1;
        while(i<(m+n)){
            if(i<n){
                r = 0;
                c++;
            } else {
                r++;
                c = 0;
            }
            int j = 0;
            Arrays.fill(arr, 0);
            while(r<m && c<n){
                arr[j++] = mat[r][c];
                r++;
                c++;
            }
            int t = 0;
            Arrays.sort(arr,(x,y) -> Integer.compare(y,x));
            while(j-->0){
                mat[--r][--c] = arr[t++];
            }
            i++;
        }
        return mat;
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0, j=0, k=n-1;i<(m+n);i++){
            if(i>n){
                j++;
                k=0;
            } else {
                k--;
                j=0;
            }
            int a = j, b = k;
            while(true){
                if(a >=0 && a<m && b>=0 && b<n){
                    pq.add(mat[a][b]);
                } else {
                    break;
                }
                a++;
                b++;
            }
            a = j; b = k;
            while(!pq.isEmpty()){
                mat[a][b] = pq.poll();
                a++;
                b++;
            }
        }
        return mat;
    }
}
