package tree;

import common.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> out = new ArrayList<>();
        if(root==null)
            return out;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levelOrder = 1; // as we have added root so now we are at level 1
        Stack<TreeNode> s = new Stack<>(); // as we need to add the nodes in opposite manner as queue
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> o = new ArrayList<>();
            while(size-->0){
                TreeNode u = q.poll();
                o.add(u.val);
                if(levelOrder%2==0){ // if even level then add right node first int stack
                    if(u.right!=null)
                        s.push(u.right);
                    if(u.left!=null)
                        s.push(u.left);
                } else { //  if off level then add left node first int stack
                    if(u.left!=null)
                        s.push(u.left);
                    if(u.right!=null)
                        s.push(u.right);
                }
            }
            while(!s.isEmpty()){ // move all the nodes to queue from stack
                q.add(s.pop());
            }
            levelOrder++; //increment the level
            out.add(o);
        }

        return out;
    }
}
