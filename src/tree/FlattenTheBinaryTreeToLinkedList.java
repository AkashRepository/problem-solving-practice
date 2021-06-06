package tree;

import common.TreeNode;

public class FlattenTheBinaryTreeToLinkedList {

    private void traverse(TreeNode node){
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            return;
        }

        traverse(node.left);
        traverse(node.right);

        if(node.left!=null){
            TreeNode right = node.right;

            TreeNode left = node.left;

            while(left.right!=null){
                left = left.right;
            }
            node.right = node.left;
            left.right = right;
            node.left = null;
        }
    }

    public void flatten(TreeNode root) {
        traverse(root);
    }
}
