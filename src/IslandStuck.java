import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandStuck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nmr[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);
        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        while (m-- > 0) {
            String uv[] = br.readLine().trim().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            in[v]++;
            out[u]++;
            adj[u].add(v);
        }
        String result = "";
        boolean visited[] = new boolean[n + 1];
        double[] p = new double[n + 1];
        p[r] = 1;
        double max = 0.0;
        dfs(r, visited, in, out, adj, p);
        for (int i = 1; i <= n; i++) {
            if (i != r && p[i] > max && out[i] == 0) {
                max = p[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != r && Math.abs(max - p[i]) <= Math.pow(10, -9))
                result = result + " " + i;
        }
        System.out.println(result.trim());
        br.close();
    }

    private static void dfs(int u, boolean[] visited, int[] in, int[] out, LinkedList<Integer>[] adj, double[] p) {
        visited[u] = true;
        for (int v : adj[u]) {
            p[v] += (p[u] * 1.0) / out[u];
            in[v]--;
            if (!visited[v])
                dfs(v, visited, in, out, adj, p);
        }
    }

}
