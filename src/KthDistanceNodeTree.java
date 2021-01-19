import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode l, TreeNode r) {
        this.left = l;
        this.right = r;
        val = x;
    }
}

class Graph {
    int v;
    LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }
    }

    public void add(int i, int j) {
        this.adj[i].add(j);
        this.adj[j].add(i);
    }

}

public class KthDistanceNodeTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> p = new HashMap<>();
        parents(root, null, p);
        HashSet<TreeNode> v = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int out = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                if (out == K) {
                    break;
                }
                TreeNode t = q.poll();
                v.add(t);
                if (p.get(t) != null && !v.contains(p.get(t)))
                    q.add(p.get(t));
                if (t.left != null && !v.contains(t.left))
                    q.add(t.left);
                if (t.right != null && !v.contains(t.right))
                    q.add(t.right);
            }
            out++;
            if (out == K) {
                break;
            }
        }
        return q.stream().map(queue -> queue.val).collect(Collectors.toList());
    }

    public void parents(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> p) {
        if (node == null)
            return;
        p.put(node, parent);
        parents(node.left, node, p);
        parents(node.right, node, p);
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(2, null, null);
        TreeNode r = new TreeNode(3, null, null);

        TreeNode l1 = new TreeNode(6, null, null);
        TreeNode r1 = new TreeNode(8, null, null);


        TreeNode l2 = new TreeNode(5, l, r);
        TreeNode r2 = new TreeNode(3, l1, r1);
        TreeNode root = new TreeNode(10, l2, r2);


        KthDistanceNodeTree o = new KthDistanceNodeTree();
        System.out.println(o.distanceK(root, l1, 1));
    }
}
