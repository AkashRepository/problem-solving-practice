package tree;

import common.TreeNode;

import java.util.*;

public class UniqueBinaryTreeTwo {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return traversal(1, n, dp);
    }

    public List<TreeNode> traversal(int s, int e, List<TreeNode>[][] dp) {

        List<TreeNode> out = new ArrayList<>();
        if (s > e) {
            out.add(null);
            return out;
        }

        if (dp[s][e] != null)
            return dp[s][e];

        for (int i = s; i <= e; i++) {

            List<TreeNode> left = traversal(s, i - 1, dp);
            List<TreeNode> right = traversal(i + 1, e, dp);

            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode t = new TreeNode(i);
                    t.left = a;
                    t.right = b;
                    out.add(t);
                }
            }
        }
        dp[s][e] = out;

        return out;
    }
}
