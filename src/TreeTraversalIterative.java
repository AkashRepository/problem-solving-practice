import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalIterative {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node!=null){
            while(node!=null){
                arr.add(node.val);
                if(node.right!=null)
                    stack.push(node.right);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
            }
        }
        return arr;

    }

    public void inorderTraversal(TreeNode node, List<Integer> l){
        if(node==null)
            return;
        // foo(node.left, l);
        // l.add(node.val);
        // foo(node.right, l);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left = node;
        while(left!=null || !stack.isEmpty()){
            while(left!=null){
                stack.push(left);
                left = left.left;
            }
            if(!stack.isEmpty()){
                TreeNode le = stack.pop();
                l.add(le.val);
                left = le.right;
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        Stack<TreeNode> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            while(node!=null ){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode n = stack.peek();
                if(n.right!=null )
                    node = n.right;
                else{
                    stack.pop();
                    arr.add(n.val);
                    while(!stack.isEmpty() && stack.peek().right!=null && stack.peek().right == n){
                        n = stack.pop();
                        arr.add(n.val);
                    }
                    node = null;
                }

            }
            // if(!stack.isEmpty())
            //     node = stack.pop();
        }
        return arr;


    }
}
