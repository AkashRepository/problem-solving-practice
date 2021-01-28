public class PathOfMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        if(n<1)
            return 0;
        int m = heights[0].length;
        if(m<1) {
            return 0;
        }
        int[] re = new int[]{Integer.MAX_VALUE};
        int t = heights[0][0];
        dfs(0,0,heights, n-1,m-1,Integer.MAX_VALUE, re);
//        heights[0][0] = -1;
//        dfs(0,1,heights,n-1,m-1,t, re);
//        int min = re[0];
//        dfs(1,0,heights,n-1,m-1, t, re);
        return re[0];
    }

    public int dfs(int i, int j, int[][] h, int x, int y, int p, int[] re){

        if(i < 0 || i > x || j < 0 || j > y){
            return -1;
        }
        if(h[i][j]==-1)
            return -1;
        if(i==x && j==y){
            return Math.abs(p - h[i][j]);
        }
        int t = h[i][j];
        h[i][j]=-1;
        int max = Math.abs(p - t);
        int mi = Integer.MAX_VALUE;
        int a = dfs(i,j+1,h, x,y, t, re);

        max = Math.max(a, max);
        if(a!=-1)
            mi = Math.min(a, mi);

        int b = dfs(i+1,j,h, x,y, t,re);
        max = Math.max(b, max);
        if(b!=-1)
            mi = Math.min(b, mi);

        int c = dfs(i,j-1,h, x,y, t,re);
        max = Math.max(c, max);
        if(c!=-1)
            mi = Math.min(c, mi);

        int d = dfs(i-1,j,h, x,y, t,re);
        max = Math.max(d, max);
        if(d!=-1)
            mi = Math.min(d, mi);
        h[i][j] = t;
        if(a==-1 && b==-1 && c==-1 && d==-1)
            return -1;
//        if(mi < re[0])
            re[0] = mi;
        return max;
    }

    public static void main(String[] args) {
        PathOfMinimumEffort o = new PathOfMinimumEffort();
        Integer.toBinaryString(23);

        System.out.println(o.minimumEffortPath(new int[][] {{1,2,2},{3,8,2},{5,3,5}}));
    }
}
