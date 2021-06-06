package topologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class CoursesSchedule {

    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        LinkedList<Integer>[] adjs = new LinkedList[n];

        for(int i=0;i<n;i++){
            adjs[i] = new LinkedList<>();
        }
        for(int[] edges: prerequisites){
            adjs[edges[0]].add(edges[1]);
            indegree[edges[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int courses = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            courses++;
            for(int v: adjs[u]){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }

        return courses == n;
    }
}
