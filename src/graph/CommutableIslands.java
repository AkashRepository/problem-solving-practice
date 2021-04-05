package graph;

import java.util.*;

public class CommutableIslands {

    static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    /*
    Dijkstra's algorithm for minimum distance between two nodes
     */
    private int minDistance(List<List<Node>> adj, int A, int[] distance, Set<Integer> vi) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(1, 0));
        distance[1] = 0;
        while (vi.size() != A) {
            Node node = pq.poll();
            vi.add(node.v);
            for (Node v : adj.get(node.v)) {
                if (!vi.contains(v.v)) {
                    int cost = v.cost;

                    if (distance[v.v] > distance[node.v] + cost)
                        distance[v.v] = distance[node.v] + cost;
                    System.out.println(distance[v.v]);
                    pq.offer(new Node(v.v, distance[v.v]));
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= A; i++) {
            sum = sum + distance[i];
        }
        return sum;
    }

    private int find(int i, int[] p) {
        if (p[i] == i)
            return i;
        p[i] = find(p[i], p);
        return p[i];
    }

    private void union(int i, int j, int[] p, int[] r) {

        if (i == j) {
            return;
        }
        if (r[i] >= r[j]) {
            r[i] = r[i] + r[j];
            p[i] = j;
            r[i]++;
        } else {
            r[j] = r[j] + r[i];
            p[j] = i;
        }

    }

    /*
    minimum path sum using kruskal's algorithm and disjoint set
     */
    public int solve(int A, List<List<Integer>> B) {

        int out = 0;
        Collections.sort(B, (a, b) -> a.get(2) - b.get(2));
        Set<Integer> hs = new HashSet<>();
        int[] p = new int[A + 1];
        int[] r = new int[A + 1];
        for (int i = 0; i <= A; i++) {
            p[i] = i;
        }
        for (List<Integer> b : B) {
            int u = b.get(0);
            int v = b.get(1);
            int up = find(u, p);
            int vp = find(v, p);
            if (up != vp) {
                union(up, vp, p, r);
                out = out + b.get(2);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        CommutableIslands o = new CommutableIslands();
        System.out.println(o.solve(4, Arrays.asList(Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 2),
                Arrays.asList(3, 4, 4),
                Arrays.asList(1, 4, 3))));
    }

}
