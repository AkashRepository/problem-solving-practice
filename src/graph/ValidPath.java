package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidPath {

    public static void main(String[] args) {
        ValidPath o = new ValidPath();
        System.out.println(o.solve(2,3,1,1, Arrays.asList(2), Arrays.asList(3)));
    }

    public String solve(int A, int B, int C, int D, List<Integer> E, List<Integer> F) {
        boolean[][] visited = new boolean[A+1][B+1];
        if(dfs(0,0,A,B,D, visited, E, F))
            return "YES";

        return "NO";

    }

    private boolean dfs(int i, int j, int x, int y, int r, boolean[][] visited, List<Integer> E, List<Integer> F) {

        if(i<0||j<0||i>x||j>y||visited[i][j]){
            return false;
        }


        for(int ii=0;ii<E.size();ii++){
            int value = (i-E.get(ii))*(i-E.get(ii)) + (j-F.get(ii))*(j-F.get(ii));
            if(value <= r*r)
                return false;
        }

        if(i==x && j==y)
            return true;
        visited[i][j] = true;
        boolean flag = dfs(i+1,j+1,x,y,r, visited, E, F) ||
                dfs(i-1,j+1,x,y,r, visited, E, F) ||
                dfs(i+1,j-1,x,y,r, visited, E, F) ||
                dfs(i-1,j-1,x,y,r, visited, E, F) ||
                dfs(i,j-1,x,y,r, visited, E, F) ||
                dfs(i,j+1,x,y,r, visited, E, F) ||
                dfs(i+1,j,x,y,r, visited, E, F) ||
                dfs(i-1,j,x,y,r, visited, E, F);


        return flag;
    }
}
