import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        PostOrderTraversal o = new PostOrderTraversal();
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        System.out.println(o.postorderTraversal(s.deserialize(",1,null,2,3")));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        Stack<TreeNode> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.add(node);
                if(node.right!=null)
                    stack.add(node.right);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode n = stack.pop();
                if(n.left!=null)
                    node = n.left;
                else if(n.right!=null)
                    node = n.right;
                else{
                    arr.add(n.val);
                    node = null;
                }

            }
            // if(!stack.isEmpty())
            //     node = stack.pop();
        }
        return arr;


    }
}
