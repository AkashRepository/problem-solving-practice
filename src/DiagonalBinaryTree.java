import common.TreeNode;

import java.util.ArrayList;
import java.util.TreeMap;

public class DiagonalBinaryTree {

    private void traversal(TreeNode node, int s, TreeMap<Integer, ArrayList<Integer>> m){
        if(node==null)
            return;
        ArrayList<Integer> a = m.getOrDefault(s, new ArrayList<>());
        a.add(node.val);
        m.put(s, a);
        traversal(node.left, s+1, m);
        traversal(node.right, s, m);
    }


    public ArrayList<Integer> solve(TreeNode A) {

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        traversal(A, 0, m);

        ArrayList<Integer> arr = null;
        for(Integer v : m.keySet()){
            if(arr==null)
                arr = m.get(v);
            else
                arr.addAll(m.get(v));
        }
        return arr;

    }
}
