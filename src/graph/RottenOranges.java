package graph;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private boolean isValid(int i, int j, int[][] grid){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // boolean[][] vi = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int out = 0;
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            // System.out.println(size);
            out++;
            while(size-->0){
                int[] u = q.poll();
                for(int i=0;i<4;i++){
                    if(isValid(u[0]+dir[i][0],u[1]+dir[i][1],grid)){
                        grid[u[0]+dir[i][0]][u[1]+dir[i][1]] = 2;
                        q.add(new int[]{u[0]+dir[i][0],u[1]+dir[i][1]});
                    }
                }
            }

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return out==0?out:out-1;
    }
}
