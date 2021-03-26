package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private void dfs(int[][] m, boolean[][] vi, int x, int y, int prev){
        if(x>=m.length || y>=m[0].length || x<0 || y<0 || vi[x][y] || m[x][y]<prev){
            return;
        }

        vi[x][y]=true;

        dfs(m,vi,x+1,y,m[x][y]);
        dfs(m,vi,x-1,y,m[x][y]);
        dfs(m,vi,x,y+1,m[x][y]);
        dfs(m,vi,x,y-1,m[x][y]);

    }




    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> out = new ArrayList<>();
        int m = matrix.length;
        if(m==0)
            return out;
        int n = matrix[0].length;

        boolean[][] vp = new boolean[m][n];
        boolean[][] va = new boolean[m][n];

        for(int i=0;i<n;i++){
            dfs(matrix, vp, 0, i, Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            dfs(matrix, vp, i, 0, Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            dfs(matrix, va, i, n-1, Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++){
            dfs(matrix, va, m-1, i, Integer.MIN_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(va[i][j] && vp[i][j]){
                    out.add(Arrays.asList(i,j));
                }
            }
        }

        return out;
    }
}
