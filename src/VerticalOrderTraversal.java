import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
        TreeNode node = root;
        int[] h = new int[1001];
        int c = 0;
        height(1, root, h);
        func(root, c, tree);
        List<List<Integer>> out = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> e : tree.entrySet()) {
            e.getValue().sort((a, b) -> {
                return h[a] < h[b] ? -1 : h[a] == h[b] ? a < b ? -1 : 1 : 1;
            });
            out.add(e.getValue());
        }
        return out;
    }

    private void height(int height, TreeNode node, int[] h) {
        if (node == null)
            return;
        h[node.val] = height;
        height(height + 1, node.left, h);
        height(height + 1, node.right, h);
    }

    private void func(TreeNode node, Integer c, TreeMap<Integer, ArrayList<Integer>> tree) {
        if (node == null)
            return;
        ArrayList<Integer> p = tree.getOrDefault(c, new ArrayList<Integer>());
        p.add(node.val);
        tree.put(c, p);
        func(node.left, c - 1, tree);
        func(node.right, c + 1, tree);
    }

    public static void main(String[] args) {
        VerticalOrderTraversal o = new VerticalOrderTraversal();
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        TreeNode deserialize = s.deserialize(",0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9");
        System.out.println(o.verticalTraversal(deserialize));
    }
}
