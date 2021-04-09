package tree;

import common.TreeNode;

public class BinaryTreeCamera {

    private final int NEED = 0;
    private final int NO_NEED = 1;
    private final int WITH_CAMERA = 2;

    private int traverse(TreeNode node){
        if(node==null)
            return NO_NEED;
        int left = traverse(node.left);
        int right = traverse(node.right);
        if(left==NEED || right==NEED){
            count++;
            return WITH_CAMERA;
        }
        if(left==WITH_CAMERA || right==WITH_CAMERA){
            return NO_NEED;
        }
        return NEED;
    }
    int count =0;
    public int minCameraCover(TreeNode root) {
        if(NEED == traverse(root))
            count++;
        return count;
    }
}
