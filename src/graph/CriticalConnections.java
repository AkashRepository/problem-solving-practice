package graph;

import java.util.*;


public class CriticalConnections {


    class Graph {
        List<Integer>[] adj;

        public Graph(int n) {
            this.adj = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void add(int a, int b) {
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    int idx = 0;
    int s = 0;

    public void dfs(int curr, int[] ids, int[] low, List<List<Integer>> out, Graph g, int p) {
        ids[curr] = low[curr] = ++idx;
        for (int v : g.adj[curr]) {
            if(v==p)
                continue;
            if (ids[v] == -1) { //unvisited
                dfs(v, ids, low, out, g, curr);
            }
            low[curr] = Math.min(low[curr], low[v]);
            if(ids[curr] < low[v]){
                out.add(Arrays.asList(curr, v));
            }
        }
    }


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph g = new Graph(n);
        for (List<Integer> a : connections) {
            g.add(a.get(0), a.get(1));
        }
        int[] low = new int[n];
        int[] ids = new int[n];
        Arrays.fill(ids, -1);

        List<List<Integer>> out = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<n;i++){
            if(ids[i]==-1) {
                dfs(0, ids, low,out, g, -1);
            }
        }

        return out;
    }

    public static void main(String[] args) {
        CriticalConnections o = new CriticalConnections();
        System.out.println(o.criticalConnections(4, Arrays.asList(Arrays.asList(0,1),Arrays.asList(1,2),Arrays.asList(2,0),Arrays.asList(1,3))));
    }

}
