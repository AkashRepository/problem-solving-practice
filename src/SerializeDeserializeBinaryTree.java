import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

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
