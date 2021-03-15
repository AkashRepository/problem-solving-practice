package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestSmallestElement {

    static class BST{
        Integer val;
        BST left;
        BST right;

        public BST(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        NearestSmallestElement o = new NearestSmallestElement();
        o.prevSmaller(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
    }

    private BST insert(int val,BST parent, BST root){

        if(root==null){
            root = new BST(val);
            return root;
        }

        if(val > root.val){
            root.right =  insert(val,root,  root.right);
        }
        root.left = insert(val, root, root.left);
        return root;
    }

    private BST search(int val,BST parent, BST root){
        if(root==null)
            return parent;
        if(val > root.val){
            return search(val, root, root.right);
        }
        return search(val, root, root.left);
    }


    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        BST root = null;
        int min = Integer.MAX_VALUE;
        int i=0;
        int[] arr = new int[A.size()];
        ArrayList<Integer> out = new ArrayList<>();
        for(Integer a : A){
            root = insert(a, null, root);
            min = Math.min(min, a);
            if(min > a){
                out.add(-1);
            } else {
                BST s = search(a-1,null, root);
                if(s==null){
                    out.add(-1);
                } else {
                    out.add(s.val);
                }
            }
            i++;
        }
        return out;
    }
}
