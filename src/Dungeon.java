import java.util.Arrays;

public class Dungeon {

    public int calculateMinimumHP2(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int a[] : dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        int out = func(0, 0, 0 , dungeon, dp);
        return out==0?1:out;

    }

    public int func(int i, int j, int res, int[][] dungeon, int[][] dp){
        if(i>=dungeon.length || j >=dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int out = 0;
        int value = dungeon[i][j];
        if((res + value) <= 0){
            out = (Math.abs(res + value) + 1);
            res = 1;
        } else {
            res = res + value;
        }
        if(i==dungeon.length-1 && j==dungeon[0].length-1){
            return out;
        }
        dp[i][j] = out + Math.min(func(i, j+1, res, dungeon,dp) ,func(i+1, j, res, dungeon,dp));
        return dp[i][j];

    }


    public int calculateMinimumHP(int[][] dungeon) {
        int v = dungeon.length * dungeon[0].length;
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int e = dungeon.length * (dungeon[0].length + 1);
        dist[0] = dungeon[0][0] > 0 ? 0 : -1 * dungeon[0][0];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < dungeon.length; j++) {
                for (int k = 0; k < dungeon[0].length; k++) {
//                    if (j == 0 && k == 0)
//                        continue;
                    int u = j + k;
                    int v1 = u + 1;

                    int weight = dungeon[j][k];
                    if (u < v && v1 < v) {
                        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v1])
                            dist[v1] = dist[u] + weight;
                    }
                    int v2 = u + dungeon[0].length + 1;
                    if (u < v && v2 < v) {
                        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v2])
                            dist[v2] = dist[u] + weight;
                    }

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Dungeon o = new Dungeon();

        System.out.println(o.calculateMinimumHP2(new int[][]{{-2, -3, 3},{-5, -10, 1}, {10, 30, -5}}));
    }
}
