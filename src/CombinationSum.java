import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum o =new CombinationSum();
        o.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(o.out);
    }

    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] c, int k) {

        out = new ArrayList<>();
        Arrays.sort(c);
        int n = c.length;
        List<Integer> a =  new ArrayList<>();
        sum(0,0, k, c, a);
        return out;
    }

    private  void sum(int i, int sum, int k, int[] c, List<Integer> arr){
        if(i>=c.length){
            return ;
        }
        if(sum>k)
            return ;

        if(sum==k){
            out.add(new ArrayList<>(arr));
            return ;
        }
        for(int ii=i;ii<c.length;ii++){
            arr.add(c[ii]);
            sum(ii,sum+c[ii], k, c, arr);
            arr.remove(arr.size()-1);
        }
    }
}
