import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree o = new SymmetricTree();
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        TreeNode deserialize = s.deserialize(",1,2,2,null,3,null,3");
        o.isSymmetric(deserialize);

    }
    private int count(TreeNode node){
        if(node==null)
            return 0;
        int count = count(node.left);
        count++;
        return count + count(node.right);
    }

    /**
    Two Queue approach
     */
    private boolean leftRight(TreeNode t){
        if(t==null)
            return true;
        if(t.left==null && t.right==null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(t.left);
        q2.add(t.right);

        int count = count(t);
        count=count-3;
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode u = q1.poll();
            TreeNode v = q2.poll();
            if(u==null || v==null)
                return false;
            if(u.val!=v.val)
                return false;
            if(u.left!=null && v.right!=null){
                q1.add(u.left);q2.add(v.right);
                count=count-2;
            }
            if(u.right!=null && v.left!=null){
                q1.add(u.right);q2.add(v.left);
                count=count-2;
            }
        }
        return q1.isEmpty() && q2.isEmpty() && count==0;
    }


    public boolean isSymmetric(TreeNode root) {
        return leftRight(root);
    }
}
