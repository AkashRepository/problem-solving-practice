public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, out = 0;
        boolean[] v = new boolean[n];
        for(int i=0;i<n;i++){
            if(!v[i]){
                dfs(isConnected, v, i);
                out++;
            }
        }
        return out;
    }

    public void dfs(int[][] isConnected, boolean[] v, int i){
        v[i] = true;
        for(int j=0;j<isConnected.length;j++){
            if(!v[j] && isConnected[i][j]==1)
                dfs(isConnected, v, j);
        }
    }
}
