import java.util.Arrays;

public class AdvanceShuffle {

    static class BST {
        int val;
        BST left;
        BST right;
        int idx;
        boolean flag = true;

        public BST(int idx, int val){
            this.idx=idx;
            this.val= val;
        }
    }

    private BST insert(BST t, int val, int idx){
        if(t==null){
            return new BST(idx, val);
        }
        if(t.val<val){
            t.right = insert(t.right, val, idx);
        } else {
            t.left = insert(t.left, val, idx);
        }
        return t;
    }

    private BST dfs(BST tree){
        if(tree==null)
            return null;
        if(tree.flag)
            return tree;
        BST left = dfs(tree.left);
        if(left!=null)
            return left;
        return dfs(tree.right);
    }

    private BST find(BST tree, int val){
        if(tree==null)
            return null;
        BST node = new BST(-1,-1);
        if(tree.val<=val){
            BST right = find(tree.right, val);
            if(right!=null){
                node = right;
            }
        } else {
            if(tree.flag)
                node = tree;
            BST left = find(tree.left, val);
            if(left!=null){
                node = left;
            }
        }
        return node;
    }

    public int[] advantageCount(int[] A, int[] B) {

        BST tree = null;
        int n = A.length;
        for (int i = 0; i < n; i++)
            tree = insert(tree, A[i], i);
        int i = 0;
        for (; i < n; i++) {
            BST val = find(tree, B[i]);
            if (val.val == -1) {
                break;
            }
            A[i] = val.val;
            val.flag = false;
//            int idx = val.idx;
//            int temp = A[idx];
//            A[idx] = A[i];
//            A[i] = temp;
        }
        while(i<n){
            BST node = dfs(tree);
            A[i++] = node.val;
            node.flag = false;
        }
        return A;
    }

    public static void main(String[] args) {
        AdvanceShuffle o = new AdvanceShuffle();
        System.out.println(Arrays.toString(o.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
    }
}
