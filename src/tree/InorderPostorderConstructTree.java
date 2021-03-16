package tree;

import common.TreeNode;

public class InorderPostorderConstructTree {

    private TreeNode buildTree(int[] in, int[] post, int inorderStart, int inorderEnd, int postorderEnd) {

        if (inorderStart > inorderEnd || postorderEnd < 0) {
            return null;
        }

        TreeNode node = new TreeNode(post[postorderEnd]);
        int i = -1;
        for (i = inorderStart; i <= inorderEnd; i++) {
            if (in[i] == node.val) {
                break;
            }
        }
        // postorder end for left node will move inorderEnd - i forward. So, postorderEnd = postorderEnd - 1 - (inorderEnd - i)
        node.left = buildTree(in, post, inorderStart, i - 1, postorderEnd - 1 - inorderEnd + i);
        node.right = buildTree(in, post, i + 1, inorderEnd, postorderEnd - 1);
        return node;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;

        return buildTree(inorder, postorder, 0, n - 1, n - 1);
    }
}
