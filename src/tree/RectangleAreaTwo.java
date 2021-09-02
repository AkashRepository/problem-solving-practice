package tree;

import java.util.Arrays;

public class RectangleAreaTwo {

    public static void main(String[] args) {
        RectangleAreaTwo o = new RectangleAreaTwo();
        System.out.println(o.rectangleArea(new int[][]{{0,0,3,3},{2,0,5,3},{1,1,4,4}}));
    }

    private static class Node {
        Node left;
        Node right;
        int leftVal;
        int rightVal;
        long sum;
        int value;

        Node(int leftVal, int rightVal, int value){
            this.leftVal = leftVal;
            this.rightVal = rightVal;
            this.value = value;
            this.sum = this.value > 0 ? rightVal - leftVal + 1 : 0;
        }
    }

    private void add(Node node, int leftVal, int rightVal, int value){
        if(leftVal <= node.leftVal && node.rightVal <= rightVal){
            if(node.left == null && node.right== null){
                node.value += value;
                node.sum = node.value > 0 ? node.rightVal - node.leftVal + 1: 0;
            } else {
                add(node.left, leftVal, rightVal, value);
                add(node.right, leftVal, rightVal, value);
                node.sum = node.left.sum + node.right.sum;
            }
        } else {
            int mid = (node.leftVal + node.rightVal)/2;
            if(node.left == null)
                node.left = new Node(node.leftVal, mid, node.value);
            if(node.right == null)
                node.right = new Node(mid+1, node.rightVal, node.value);
            if(leftVal<=mid){
                add(node.left, leftVal, rightVal, value);
            }
            if(rightVal>mid){
                add(node.right, leftVal, rightVal, value);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        int[][] list = new int[2*n][4];
        long MOD = 1_000_000_007;
        int i = 0;
        for(int[] curr: rectangles){
            list[i++] = new int[]{curr[0], curr[2], curr[1], 1};
            list[i++] = new int[]{curr[0], curr[2], curr[3], -1};
        }
        Arrays.sort(list, (a,b) -> Integer.compare(a[2], b[2]));
        long out = 0l;
        int prev = list[0][2];
        Node root = new Node(0, 1_000_000_008, 0);
        for(int[] curr: list){
            if(prev != curr[2]){
                out = (out + (root.sum * (curr[2] - prev))%MOD)%MOD;
                prev = curr[2];
            }
            add(root, curr[0], curr[1]-1, curr[3]);
        }
        return (int)out;
    }
}
