package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    private List<TreeNode> traverse(int n){

        List<TreeNode> arr = new ArrayList<>();
        if(n==1){
            arr.add(new TreeNode(0));
            return arr;
        }
        for(int i=1;i<n;i++){
            List<TreeNode> left = traverse(i);
            List<TreeNode> right = traverse(n-i-1);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode t = new TreeNode(0);
                    t.left = l;
                    t.right = r;
                    arr.add(t);
                }
            }
        }
        return arr;

    }

    public List<TreeNode> allPossibleFBT(int n) {
        return traverse(n);
    }
}
