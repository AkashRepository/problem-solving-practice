package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum o =new CombinationSum();
        o.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(o.out);
    }

    List<List<Integer>> out = new ArrayList<>();

    private void combination(ArrayList<Integer> a, int b, int idx, int sum, ArrayList<Integer> temp){
        if(idx>=a.size())
            return;
        if(sum>b)
            return;
        if(sum==b){
            out.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<a.size();i++){
            temp.add(a.get(i));
            combination(a, b, i, sum+a.get(i), temp);
            temp.remove(temp.size()-1);
        }
    }
    //with duplicate elements in input arraylist
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> newList = new ArrayList<>(new HashSet<>(A));
        Collections.sort(newList);
        // for(int i=0;i<A.size();i++)
        combination(newList, B, 0, 0, new ArrayList<>());
        return null;//return out
    }
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
