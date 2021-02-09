import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    private boolean isSafe(ArrayList<Integer> l, int i, int j){
        return i>=0 && j>=0 && i<l.size()&& j<l.size();
    }

    public ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if(A==0)
            return out;
        ArrayList<Integer> n = new ArrayList<>();
        n.add(1);
        out.add(n);
        for(int i=1;i<A;i++){
            n = new ArrayList<>();
            ArrayList<Integer> prev = out.get(i-1);
            for(int j=0;j<=i;j++){
                if(isSafe(prev, j-1, j)){
                    n.add(prev.get(j-1) + prev.get(j));
                } else {
                    n.add(1);
                }
            }
            out.add(n);
        }
        return out;
    }

    public static void main(String[] args) {
        PascalTriangle o =new PascalTriangle();
        System.out.println(o.solve(5));

    }
}
