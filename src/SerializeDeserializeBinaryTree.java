import common.TreeNode;

import java.util.*;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int s = q.size();
            StringBuilder str = new StringBuilder();
            boolean flag = false;
            for(int i=0;i<s;i++){
                TreeNode n = q.poll();
                if(n==null){
                    str.append(",null");
                } else {
                    str.append(",").append(n.val);
                    q.add(n.left);
                    q.add(n.right);
                    flag = true;
                }
            }
            if(flag){
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode node = getNode(1, nodes);
        TreeNode root = node;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 2;
        q.add(node);
        while(!q.isEmpty() && i<nodes.length){
            TreeNode n = q.poll();
            n.left = getNode(i++, nodes);
            if(i+1<nodes.length)
                n.right = getNode(i++, nodes);
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
        return root;
    }

    public TreeNode getNode(int idx, String[] nodes){
        if(nodes[idx].equals("null")){
            return null;
        }
        return new TreeNode(Integer.parseInt(nodes[idx]));
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree o = new SerializeDeserializeBinaryTree();
        System.out.println(o.deserialize(",1,2,3,null,null,4,5"));
    }
}
