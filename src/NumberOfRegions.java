import java.util.*;

public class NumberOfRegions {

    public static void main(String[] args) {
        NumberOfRegions o = new NumberOfRegions();
        System.out.println(o.solve(Arrays.asList(
                Arrays.asList(0, 0, 1, 0, 0, 1,1, 1),
                Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1)
        )));
    }

    private boolean isSafe(int i, int j, int m, int n, List<List<Integer>> A) {
        return i >= 0 && j >= 0 && i < m && j < n && A.get(i).get(j) == 1;
    }

    public int solve(List<List<Integer>> A) {

        int m = A.size();
        if (m == 0) {
            return 0;
        }
        int n = A.get(0).size();
        int[][] dir = new int[][]{{1, 1}, {0, 1}, {1, 0}, {1, -1}};
        Queue<int[]> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    A.get(i).set(j, 0);
                    int temp = 0;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        temp = temp + 1;
                        System.out.println(size);
                        int[] u = q.poll();
                        while (size-- > 0) {
                            for (int k = 0; k < 4; k++) {
                                if (isSafe(u[0] + dir[k][0], u[1] + dir[k][1], m, n, A)) {
                                    q.add(new int[]{u[0] + dir[k][0], u[1] + dir[k][1]});
                                    A.get(u[0] + dir[k][0]).set(u[1] + dir[k][1], 0);
                                }
                                if (isSafe(u[0] - dir[k][0], u[1] - dir[k][1], m, n, A)) {
                                    q.add(new int[]{u[0] - dir[k][0], u[1] - dir[k][1]});
                                    A.get(u[0] - dir[k][0]).set(u[1] - dir[k][1], 0);
                                }
                            }
                        }
                        max = Math.max(temp, max);
                    }
                }
            }
        }
        return max;
    }
}
