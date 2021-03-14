import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class VisibleNodesInTree {



    private int maximumVisibleNodes(TreeNode node, int maximumTillNow, int visibleNodes) {
        if (node == null)
            return visibleNodes;
        if (node.val > maximumTillNow) {
            visibleNodes++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
//        Arrays.stream(new int[]{}).mapToObj(Integer::valueOf).collect(Collectors.toList());
        maximumTillNow = Math.max(node.val, maximumTillNow);
        visibleNodes = maximumVisibleNodes(node.left, maximumTillNow, visibleNodes);
        return maximumVisibleNodes(node.right, maximumTillNow, visibleNodes);
    }


    public int goodNodes(TreeNode root) {
        int count = 0;
        if (root == null)
            return count;
        return maximumVisibleNodes(root, Integer.MIN_VALUE, 0);
    }

}
