package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CountNodes {

    private int height(TreeNode node){
        if(node.left==null && node.right==null){
            return 0;
        } else if(node.right==null){
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> l = new ArrayList<>();
        return 1 + height(node.left);
    }

    private void findLeaf(TreeNode node, int h, int noOfLeaf){
        if(node.left==null && node.right==null){
            return;
        } else if(node.right==null){
            totalNodes = totalNodes - noOfLeaf/2;
            return;
        }
        int right = height(node.right);
        if(right==h-1){
            findLeaf(node.right, right, noOfLeaf/2);
            return;
        }
        totalNodes = totalNodes - noOfLeaf/2; // reduce the number of nodes which are not present from right
        findLeaf(node.left, h-1, noOfLeaf/2);
    }

    int totalNodes = 0;

    public int countNodes(TreeNode root) {
        totalNodes = 0;
        if(root==null)
            return 0;
        int h = height(root);
        totalNodes = (1<<(h+1))-1; // total number of nodes in full binary tree
        int noOfLeaf = (totalNodes+1)/2; // number of leafs in full binary tree
        findLeaf(root, h, noOfLeaf);
        return totalNodes;
    }
}
