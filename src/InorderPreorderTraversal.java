import java.util.ArrayList;
import java.util.Arrays;

public class InorderPreorderTraversal {


    private TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart){

        if(inorderStart > inorderEnd || preorderStart < 0){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderStart]);
        int i = -1;
        for(i=inorderStart; i<=inorderEnd; i++){
            if(inorder[i]==node.val){
                break;
            }
        }

        node.left = buildTree(preorder, inorder, inorderStart, i-1, preorderStart + 1);
        // We need to move forward the preorderStart index by number of nodes present in left subtree. As, preorder is root -> left -> right, to get to the right now we need to skip number of nodes from the left subtree.
        node.right = buildTree(preorder, inorder, i+1, inorderEnd, preorderStart + 1 + (i - inorderStart));

        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        return buildTree(preorder, inorder, 0, n-1, 0);
    }
}
