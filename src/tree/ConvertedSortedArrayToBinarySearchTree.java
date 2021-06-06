package tree;

import common.TreeNode;

public class ConvertedSortedArrayToBinarySearchTree {

    private TreeNode inorder(int[] nums, int i, int j){
        if(i>=nums.length || j<0 || i>j)
            return null;
        if(i==j){
            return new TreeNode(nums[i]);
        }

        int mid = (i+j)/2; // 2
        TreeNode node = new TreeNode(nums[mid]);

        node.left = inorder(nums, i, mid-1); // 0,1
        node.right = inorder(nums, mid+1, j); //1,3

        return node;
    }
    //0,3 = 1
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length);
    }
}
