public class SwapTwoNodesInBST {

    public static void main(String[] args) {
        SwapTwoNodesInBST o = new SwapTwoNodesInBST();
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        TreeNode deserialize = s.deserialize(",1,3,null,null,2");
        o.recoverTree(deserialize);
        System.out.println(deserialize);
    }

    private boolean isValid(TreeNode node, TreeNode prev, boolean f){
        if(f)
            return f;
        if(node==null)
            return false;

        f = isValid(node.left, node, f);
        if(prev!=null && node.val<prev.val){
            int t = node.val;
            node.val = prev.val;
            prev.val = t;
            return true;
        }
        return isValid(node.right, node, f);
    }


    public void recoverTree(TreeNode root) {
        boolean f = false;
        while(!f){
            f = !isValid(root, null, f);
        }

    }
}
