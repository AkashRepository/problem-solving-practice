public class BalancedBST {

    public static void main(String[] args) {
        BalancedBST o = new BalancedBST();
        System.out.println(o.sortedArrayToBST(new int[]{1,2,3,4}));
    }


    private TreeNode inorder(int[] arr, int i){
        if(i>=arr.length)
            return null;

        TreeNode node = null;

        TreeNode left = new TreeNode(arr[i]);
        i++;
        if(i<arr.length){
            node = new TreeNode(arr[i]);
            node.left = left;
            i++;
            if(i<arr.length){
                // TreeNode right = inorder(arr, i);

                TreeNode right = new TreeNode(arr[i]);
                node.right = right;
            }
        }
        TreeNode n = inorder(arr, i);
        if(n!=null) {
            n.left = node;
            return n;
        }
        if(node!=null)
            return node;
        return left;
    }


    public TreeNode sortedArrayToBST(final int[] A) {
        return inorder(A, 0);
    }
}
