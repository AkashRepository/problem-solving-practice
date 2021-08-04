package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTreeTwo {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return traversal(1, n, dp);
    }

    public List<TreeNode> traversal(int s, int e, List<TreeNode>[][] arr) {

        List<TreeNode> out = new ArrayList<>();
        if (s > e) {
            out.add(null);
            return out;
        }

        if (arr[s][e] != null)
            return arr[s][e];

        for (int i = s; i <= e; i++) {

            List<TreeNode> left = traversal(s, i - 1, arr);
            List<TreeNode> right = traversal(i + 1, e, arr);

            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode t = new TreeNode(i);
                    t.left = a;
                    t.right = b;
                    out.add(t);
                }
            }
        }
        arr[s][e] = out;

        return out;
    }
}
