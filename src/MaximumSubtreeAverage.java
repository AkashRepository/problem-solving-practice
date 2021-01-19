import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubtreeAverage {

    Double max = null;
    MAryTreeNode mi=null;

    static class MAryTreeNode {
        int val;
        List<MAryTreeNode> children = new ArrayList<>();
    }

    public int[] sumCount(MAryTreeNode n){

        if(n==null){
            return new int[]{0,0};
        }
        int s=0,c=0;
        for(MAryTreeNode t : n.children){
            int[] scv = sumCount(t);
            s+=scv[0];
            c=c+scv[1];
        }
        s+=n.val;
        c++;
        if(max == null || max < ((s*1.0)/c)){
            max = (s*1.0)/c;
            mi = n;
        }
        return new int[]{s,c};
    }

    public MAryTreeNode subtreeMaxAvg(MAryTreeNode root) {
        MAryTreeNode out = null;
        sumCount(root);
        return this.mi;
    }

    public static void main(String[] args) {
        MaximumSubtreeAverage o = new MaximumSubtreeAverage();
        MAryTreeNode root = new MAryTreeNode();
        root.val = 10;
        MAryTreeNode l = new MAryTreeNode();
        l.val =1;
        MAryTreeNode r = new MAryTreeNode();
        r.val =12;
        root.children = Arrays.asList(l,r);
        System.out.println(o.subtreeMaxAvg(root).val);
    }
}
