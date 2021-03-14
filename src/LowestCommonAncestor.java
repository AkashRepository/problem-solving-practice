import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> pa = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        int c = 1;
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode n = qu.poll();
            if(n.left!=null){
                qu.add(n.left);
                c++;
                pa.put(n.left.val, n);
            }
            if(n.right!=null){
                qu.add(n.right);
                c++;
                pa.put(n.right.val, n);
            }
        }
        Set<Integer> v = new HashSet();
        // Arrays.fill(v, Integer.MIN_VALUE);
        // qu.add(p);
        TreeNode[] found = new TreeNode[1];
        dfs(p, found, p, q, pa, v);
        return found[0]!=null? found[0]:p;


    }

    public boolean dfs(TreeNode n, TreeNode[] found, TreeNode p, TreeNode q, Map<Integer, TreeNode> pa, Set<Integer> v) {
        if (v.contains(n.val))
            return false;

        v.add(n.val);

        if (n.val == q.val) {
            return true;
        }

        if (n.left != null && n.left.val != p.val) {
            // v[n.left.val] = v[n] + 1;
            if (found[0] == null && dfs(n.left, found, p, q, pa, v)) {
                return true;
            }
        }
        if (n.right != null && n.right.val != p.val) {
            // v[n.right.val] = v[n] + 1;
            if (found[0] == null && dfs(n.right, found, p, q, pa, v)) {
                return true;
            }
        }
        if (pa.get(n.val) != null && pa.get(n.val).val != p.val) {
            TreeNode parent = pa.get(n.val);
            // v[parent.val] = v[n] - 1;
            if (found[0] == null && dfs(parent, found, p, q, pa, v)) {
                if(found[0]==null)
                    found[0] = parent;
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<Integer>[] m = new ArrayList[1001];
        eval(root, 0, m);
        return Arrays.stream(m).filter(Objects::nonNull).map(as -> as.stream().sorted().collect(Collectors.toList())).collect(Collectors.toList());
    }

    public void eval(TreeNode node, int val, ArrayList<Integer>[] m){
        if(node == null)
            return;

        eval(node.left, val-1, m);
        if(m[val]!=null){
            m[val].add(node.val);
        } else {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(node.val);
            m[val] = l;
        }
        eval(node.right, val+1, m);

    }

    public static void main(String[] args) {

//        [1,2,3,null,4]
//        4
//        1
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        root.left = l1;
        root.right = l2;
        TreeNode l3 = new TreeNode(4);
        l1.right = l3;


//        [3,5,1,6,2,0,8,null,null,7,4]
//        5
//        TreeNode root = new TreeNode(3);
//        TreeNode l = new TreeNode(5);
//        root.left = l;
//        TreeNode r = new TreeNode(1);
//        root.right = r;
//        TreeNode l1 = new TreeNode(6);
//        TreeNode l2 = new TreeNode(2);
//        l.left = l1;
//        l.right = l2;
//        TreeNode l3 = new TreeNode(7);
//        TreeNode l4 = new TreeNode(4);
//        l2.left = l3;
//        l2.right = l4;
//        TreeNode r2 = new TreeNode(0);
//        TreeNode r3 = new TreeNode(8);
//        r.left = r2;
//        r.right = r3;
        LowestCommonAncestor o =new LowestCommonAncestor();
        System.out.println(o.lowestCommonAncestor(root, l3, root));

    }
}
