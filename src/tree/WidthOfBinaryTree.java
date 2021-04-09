package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    static class Node {
        TreeNode node;
        int val;

        Node(TreeNode node, int val){this.node=node;this.val=val;}
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root,0));
        int out = 0;
        while(!q.isEmpty()){

            int size = q.size();
            int left = 0;
            int right = 0;
            int temp = 1;
            while(temp<=size){
                Node node = q.poll();
                if(temp==1){
                    left = node.val;
                }
                if (temp==size){
                    right = node.val;
                }
                if(node.node.left!=null)
                    q.offer(new Node(node.node.left, 2*node.val+1));
                if(node.node.right!=null)
                    q.offer(new Node(node.node.right, 2*node.val+2));
                temp++;
            }
            out  = Math.max(out, right-left+1);
        }

        return out;
    }
}
