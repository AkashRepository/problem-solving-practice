package dynamicprogramming;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    public Integer traverse(TreeNode node, Map<TreeNode, Integer> map){

        if(node==null){
            map.put(node, 0);
            return 0;
        }

        Integer output = map.get(node);
        if(output!=null){
            return output;
        }

        int left = traverse(node.left, map);
        int right = traverse(node.right, map);
        int value2 = node.val;
        if(node.left!=null){
            value2 = value2 + traverse(node.left.left, map);
            value2 = value2 + traverse(node.left.right, map);
        }
        if(node.right!=null){
            value2 = value2 + traverse(node.right.left, map);
            value2 = value2 + traverse(node.right.right, map);
        }
        output =  Math.max(left+right,value2);
        map.put(node, output);
        return output;

    }


    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return traverse(root, map);
    }
}
