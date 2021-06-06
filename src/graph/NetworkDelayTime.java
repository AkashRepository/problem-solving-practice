package graph;

import java.util.*;

public class NetworkDelayTime {

    //Dijistra's algorithm
    public int networkDelayTime(int[][] times, int n, int k) {
        LinkedList<int[]>[] adj = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] t: times){
            adj[t[0]].add(new int[]{t[1],t[2]});
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1],a[1]);
        });
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(k, 0);
        q.add(new int[]{k,0});
        int sum = 0;
        while(!q.isEmpty()){

            int[] u = q.poll();

            for(int[] v: adj[u[0]]){
                if(!visited.containsKey(v[0]) || visited.get(v[0])>u[1]+v[1]){
                    q.add(new int[]{v[0], u[1]+v[1]});
                    visited.put(v[0], u[1]+v[1]);
                }
            }

        }
        if(visited.size()!=n)
            return -1;
        return Collections.max(visited.values());
    }
}
