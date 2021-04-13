package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSequenceInMatrix {

    private int dfs(int i,int j, int m, int n, int[][] matrix, int[][] vi,Integer p){
        if(i<0||j<0||i>=m||j>=n || matrix[i][j]==-1){
            return -1;
        }
        if(p!=null && matrix[i][j]>=p)
            return -1;

        if(vi[i][j]!=-1){
            return vi[i][j];
        }
        int t = matrix[i][j];
        matrix[i][j]=-1;
        int value = Math.max(
                Math.max(dfs(i+1,j,m,n,matrix,vi, t),
                        dfs(i-1,j,m,n,matrix,vi,t)),
                Math.max(dfs(i,j+1,m,n,matrix,vi,t),
                        dfs(i,j-1,m,n,matrix,vi,t))
        );
        value = Math.max(value,0);
        vi[i][j] = value+1;
        matrix[i][j]=t;

        // System.out.println("i:"+i+"j:"+j);
        // for(int[] a: vi){
        //     System.out.println(Arrays.toString(a));
        // }
        return vi[i][j];

    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] vi = new int[m][n];
        for(int[] a: vi){
            Arrays.fill(a,-1);
        }
        int out = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                out = Math.max(out, dfs(i,j,m,n,matrix,vi,null));
            }
        }
        return out;
    }
}
