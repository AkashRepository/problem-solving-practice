package binarysearch;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListToBalancedBST {
    private void inorder(List<ListNode> arr, ListNode node){
        if(node==null)
            return;
        arr.add(node);
        inorder(arr, node.next);
    }

    private TreeNode traverse(List<ListNode> arr, int i, int j){
        if(i>j)
            return null;
        int mid = (i+j)/2;
        if(mid<0 || mid>=arr.size())
            return null;
        ListNode n = arr.get(mid);
        TreeNode t = new TreeNode(n.val);
        t.left = traverse(arr, i, mid-1);
        t.right = traverse(arr, mid+1, j);
        return t;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        inorder(arr, head);

        return traverse(arr, 0, arr.size()-1);

    }
}
