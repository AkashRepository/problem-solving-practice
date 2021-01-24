import java.util.PriorityQueue;

public class SortTheMatrixDiagonal {

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
