package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class RedundantConnection {

    private int find(int i, int[] p){
        if(p[i]==i){
            return i;
        }
        return find(p[i], p);
    }

    private void union(int i, int j, int[] p){
        int u = find(i, p);
        int v = find(j, p);
        if(u!=v){
            p[v]=u;
        }
    }

    public int[] findRedundantConnectionUnionFind(int[][] edges) {
        int n = edges.length;

        int[] p = new int[n+1];
        for(int i=1;i<=n;i++)
            p[i]=i;

        for(int[] e : edges){
            int u = find(e[0], p);
            int v = find(e[1], p);
            if(u==v){
                return e;
            }
            union(e[0],e[1],p);
        }
        return new int[]{0,0};

    }

    private boolean dfs(int i, LinkedList<Integer>[] g, boolean[] v, int dst){

        if(!v[i]){
            v[i]=true;
            if(i==dst){
                return true;
            }
            for(int j: g[i]){
                if(dfs(j,g,v,dst)){
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        boolean[] v = new boolean[n+1];

        LinkedList<Integer>[] g = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            g[i] = new LinkedList();
        }
        for(int[] e : edges){
            Arrays.fill(v,false);
            if(dfs(e[0], g,v,e[1])){
                return e;
            }

            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        return new int[]{0,0};

    }
}
