package graph;

import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        LinkedList<int[]>[] g = new LinkedList[n+1];
        for(int i=0;i<n+1;i++)
            g[i] = new LinkedList<>();
        for(int[] a: flights){
            g[a[0]].add(new int[]{a[1],a[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0,-1});
        boolean[] visited = new boolean[n+1];

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty() ){
            int[] i = q.poll();
            // System.out.println(Arrays.toString(i));

            if(i[2]>k){
                break;
            }

            if(i[0]==dst){
                min = Math.min(min, i[1]);
            }

            for(int[] j : g[i[0]]){
                if(i[1]+j[1]<min)
                    q.add(new int[]{j[0],i[1]+j[1],i[2]+1});
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

}
