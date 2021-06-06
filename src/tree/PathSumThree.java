package tree;

import common.TreeNode;

import java.util.LinkedList;

public class PathSumThree {

    static class Node {
        int val;

        public Node(int val){this.val=val;}
    }
    int count = 0;
    private void traverse(TreeNode node, int sum, LinkedList<Node> arr){
        if(node==null)
            return;

        for(Node a: arr){
            // System.out.print(a.val+" -> ");
            a.val = node.val+a.val;
            if(a.val==sum){
                // System.out.print(" | ");
                count++;
            }
        }

        arr.add(new Node(node.val));
        // System.out.print(node.val);
        //  System.out.println();
        if(node.val==sum)
            count++;

        traverse(node.left, sum, arr);
        traverse(node.right, sum, arr);

        arr.removeLast();
        for(Node a: arr){
            // System.out.print(a.val+" => ");
            a.val = a.val-node.val;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        count  = 0;
        LinkedList<Node> arr = new LinkedList<>();
        traverse(root, sum, arr);
        return count;
    }
}
