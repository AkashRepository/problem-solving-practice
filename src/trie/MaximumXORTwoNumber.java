package trie;

import java.util.HashMap;

public class MaximumXORTwoNumber {

    static class Node {
        Node[] nodes = new Node[2];
    }

    private void toBinaryString(int a, Node node){
        Node current = node;
        for(int i=31;i>=0;i--){
            int idx = a & (1<<i); // check if ith bit is set

            idx = idx == 0 ? idx : 1;

            if(current.nodes[idx] ==null)
                current.nodes[idx] = new Node();
            current = current.nodes[idx];
        }
    }

    private int dfs(Node node, int a){
        Node current = node;
        if(node==null)
            return 0;
        int out = 0;
        for(int i=31;i>=0;i--){
            int j = a & (1<<i);
            j = j == 0 ? j : 1;
            int idx = j ^ 1; // change, if j == 0 then j = 1 else j == 1 then j = 0;
            if(current.nodes[idx]!=null){
                out = out<<1;
                out = out | 1;
                current = current.nodes[idx];
            } else {
                out = out<<1;
                current = current.nodes[j];
            }

        }
        return out;
    }

    public int findMaximumXOR(int[] nums) {
        int out = 0;

        Node node = new Node();
        for(int a: nums){
            toBinaryString(a, node);
        }
        for(int a: nums){
            out = Math.max(out, dfs(node, a));
        }

        return out;
    }
}
