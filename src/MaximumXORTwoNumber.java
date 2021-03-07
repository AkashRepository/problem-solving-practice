import java.util.HashMap;

public class MaximumXORTwoNumber {

    static class Node {
        Node[] nodes = new Node[2];
    }

    private void toBinaryString(int a, Node node){
        Node current = node;
        for(int i=31;i>=0;i--){
            int idx = a & (1<<i);

            if(idx==0){
                if(current.nodes[0] ==null)
                    current.nodes[0] = new Node();
                current = current.nodes[0];
            } else {
                if(current.nodes[1]==null)
                    current.nodes[1] = new Node();
                current = current.nodes[1];
            }
        }
    }

    private int dfs(Node node, int a){
        Node current = node;
        if(node==null)
            return 0;
        int out = 0;
        for(int i=31;i>=0;i--){
            int j = a & (1<<i);
            int idx = j==0?1:0;
            if(current.nodes[idx]!=null){
                out = out<<1;
                out = out | 1;
                current = current.nodes[idx];
            } else {
                out = out<<1;
                j = j==0?0:1;
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
