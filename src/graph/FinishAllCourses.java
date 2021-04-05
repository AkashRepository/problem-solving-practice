package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FinishAllCourses {

    public static void main(String[] args) {
        FinishAllCourses o = new FinishAllCourses();
        System.out.println(o.solve(5, Arrays.asList(1, 3, 4, 5 ), Arrays.asList(2, 1, 5, 3)));
    }

    public int solve(int A, List<Integer> B, List<Integer> C) {


        int[] in = new int[A+1];
        LinkedList<Integer>[] adjs = new LinkedList[A+1];

        for(int i=0;i<=A;i++)
            adjs[i] = new LinkedList<Integer>();

        for(int i=0;i<B.size();i++)
            adjs[B.get(i)].add(C.get(i));

        for(int c: C){
            in[c]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<in.length;i++){
            if(in[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v : adjs[u]){
                in[v]--;
                if(in[v]==0)
                    q.add(v);
            }
        }
        for(int i: in){
            if(i>0)
                return 0;
        }
        return 1;
    }
}
