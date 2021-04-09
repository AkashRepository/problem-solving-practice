package tree;

import common.TreeNode;

public class SerializeBST {

    private void serializeHelperPreorder(TreeNode node, StringBuilder sb){
        if(node==null)
            return;
        sb.append(","+node.val);
        serializeHelperPreorder(node.left, sb);
        serializeHelperPreorder(node.right, sb);
    }

    // Encodes a tree to a single string. //preorder way
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelperPreorder(root, sb);
        return sb.toString();
    }

    private TreeNode traversePreorder(String[] values, int min, int max){
        if(i>=values.length)
            return null;
        Integer value = Integer.valueOf(values[i]);

        if(value==null || value<min || value>max)
            return null;
        TreeNode node = new TreeNode(value);
        i++;
        node.left = traversePreorder(values,min, value);
        node.right = traversePreorder(values,value, max);
        return node;
    }
    int i = 1;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return traversePreorder(values, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode traverse(int value, TreeNode node){
        if(node==null)
            return new TreeNode(value);
        if(node.val<value){
            node.right = traverse(value, node.right);
        } else {
            node.left = traverse(value, node.left);
        }
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] values = data.split(",");
        TreeNode node = null;
        for(int i=1;i<values.length;i++){
            node = traverse(Integer.valueOf(values[i]), node);
        }
        return node;
    }
}
