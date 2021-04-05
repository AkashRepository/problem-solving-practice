package graph;

import java.util.Arrays;
import java.util.List;

public class Knight {

    public static void main(String[] args) {
        Knight o = new Knight();
        System.out.println(o.knight(8, 8, 1, 1, 8, 8));
    }

    private boolean dfs(int i, int j, int m, int n, int u, int v, boolean[][] vi , int s){

        if(i<0||j<0||i>=m||j>=n||vi[i][j]){
            return false;
        }
        vi[i][j]=true;
        if(i==u && j==v){
            min = Math.min(min, s+1);
            return true;
        }
       dfs(i-1, j-2, m, n, u, v,vi,s+1);
                dfs(i+1, j-2, m, n, u, v,vi,s+1);
                dfs(i-1, j+2, m, n, u, v,vi,s+1);
                dfs(i+1, j+2, m, n, u, v,vi,s+1);
                dfs(i-2, j-1, m, n, u, v,vi,s+1);
                dfs(i-2, j+1, m, n, u, v,vi,s+1);
                dfs(i+2, j-1, m, n, u, v,vi,s+1);
                dfs(i+2, j+1, m, n, u, v,vi,s+1);
        return false;
    }
    int min = Integer.MAX_VALUE;
    public int knight(int A, int B, int C, int D, int E, int F) {
    boolean[][] v =  new boolean[A][B];
         dfs(C-1,  D-1,  A,  B,  E-1,  F-1,v, 0);
    return min;
    }
}
