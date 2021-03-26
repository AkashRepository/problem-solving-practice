package graph;

public class PathWithMaximumGold {

    public int getMaximumGold(int[][] grid) {
        int out = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                out = Math.max(out, dfs(i,j,0,m,n, grid));
            }
        }
        return out;
    }

    private int dfs(int i, int j, int sum, int m, int n, int[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0)
            return sum;

        int temp = grid[i][j];
        grid[i][j] = 0;
        int a = dfs(i+1, j, sum+temp, m, n, grid);
        a = Math.max(a, dfs(i-1, j, sum+temp, m, n, grid));
        a = Math.max(a, dfs(i, j-1, sum+temp, m, n, grid));
        a = Math.max(a, dfs(i, j+1, sum+temp, m, n, grid));
        grid[i][j] = temp;

        return a;
    }
}
