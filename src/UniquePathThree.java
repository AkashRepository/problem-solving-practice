public class UniquePathThree {

    public int uniquePathsIII(int[][] grid) {
        int countZero = 0;
        int[] start = new int[]{-1,-1};
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start[0] = i; start[1]=j;
                } else if(grid[i][j]==0){
                    countZero++;
                }
            }
        }
        return dfs(grid, start[0],start[1], countZero);
    }

    private int dfs(int[][] grid, int i, int j, int countZero) {
        if(i<0 || j< 0 || i>= grid.length || j>= grid[0].length || grid[i][j]==-1){
            return 0;
        }
        if(grid[i][j]==2 && countZero==0){
            return 1;
        }
        int t = grid[i][j];
        if(t==0)
            countZero = countZero - 1;
        grid[i][j] = -1;

        int res = dfs(grid, i-1, j,  countZero)
        + dfs(grid, i, j-1,  countZero)
        +dfs(grid, i, j+1,  countZero)
        +dfs(grid, i+1, j,  countZero);

        grid[i][j] = t;

        return res;
    }

    public static void main(String[] args) {
        UniquePathThree o = new UniquePathThree();
        System.out.println(o.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }

}
