package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubTree {

    private StringBuilder serialize(TreeNode node, Map<String, TreeNode> map){
        if(node==null){
            return new StringBuilder(",null");
        }
        StringBuilder left = serialize(node.left,  map);
        StringBuilder right = serialize(node.right, map);
        left.insert(0, ","+node.val).append(right);
        String s = left.toString();
        if(map.containsKey(s)){
            if(map.get(s) != null)
                out.add(map.get(s));
            map.put(s, null);
        } else {
            map.put(s, node);
        }
        return left;
    }


    List<TreeNode> out = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<>();
        serialize(root, map);
        return out;
    }
}
