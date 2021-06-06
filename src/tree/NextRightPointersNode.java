package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class NextRightPointersNode {


    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            while(size-->0){
                Node t = q.poll();
                if(prev!=null)
                    prev.next = t;
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
                prev = t;
            }
        }
        return root;
    }
}
