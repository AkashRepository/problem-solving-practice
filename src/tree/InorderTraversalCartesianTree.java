package tree;

import common.TreeNode;

import java.util.ArrayList;

public class InorderTraversalCartesianTree {
    // Cartesian tree is like heap with root greater than all children
    private TreeNode build(TreeNode root, int a) {
        if (root == null) {
            return new TreeNode(a);
        } else if (root.val > a) {
            root.right = build(root.right, a);
        } else {
            TreeNode t = new TreeNode(a);
            t.left = root;
            return t;
        }
        return root;
    }

    // input array will be like 1 2 3 4 6 4 2 1
    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = null;
        for (int a : A) {
            root = build(root, a);
        }
        return root;
    }

}
