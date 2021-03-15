package graph;

import java.util.*;

public class BipartiteGraph {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0);
        int i1 = Collections.binarySearch(integers,1);
        System.out.println(i1);
        BipartiteGraph o = new BipartiteGraph();
        System.out.println(o.isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}}));
    }

    private boolean notIn(List<Integer> a, int val, int[][] graph){

        for(int aa : a){
            for(int aaa : graph[aa]){
                if(aaa==val){
                    return false;
                }
            }
        }

        return true;
    }


    public boolean isBipartite(int[][] graph) {

        int[] added = new int[graph.length];
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int k=0;k<graph.length;k++) {
            if (added[k] == 0) {
                q.add(k);
                while (!q.isEmpty()) {
                    int i = q.poll();
                    for (int j = 0; j < graph[i].length; j++) {
                        if (added[i] == 0) {
                            if (notIn(A, i, graph)) {
                                A.add(i);
                                added[i] = 1;
                            } else if (notIn(B, i, graph)) {
                                B.add(i);
                                added[i] = 2;
                            } else {
                                return false;
                            }

                        }
                        if (added[i] == 1) {
                            if (added[graph[i][j]] == 0) {
                                if (notIn(B, graph[i][j], graph)) {
                                    B.add(graph[i][j]);
                                    added[graph[i][j]] = 2;
                                    q.add(graph[i][j]);
                                } else {
                                    return false;
                                }
                            }
                        } else if (added[i] == 2) {
                            if (added[graph[i][j]] == 0) {
                                if (notIn(A, graph[i][j], graph)) {
                                    A.add(graph[i][j]);
                                    added[graph[i][j]] = 1;
                                    q.add(graph[i][j]);
                                } else {
                                    return false;
                                }
                            }
                        }

                    }
                }
            }
        }

        return true;
    }
}
