package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllUniquePermutations {

    public static void main(String[] args) {
        AllUniquePermutations o = new AllUniquePermutations();
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 9));
        System.out.println(o.permute(a));
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> out  = new ArrayList<ArrayList<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: A){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        permutate(0, A.size(), new ArrayList<Integer>(), out, map);
        return out;
    }


    private void permutate(int idx, int n, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> out, Map<Integer, Integer> map) {
        if(idx==n){
            out.add(new ArrayList<>(arr));
            return;
        }
        for(Integer key : map.keySet()){
            Integer val = map.get(key);
            if(val > 0){
                map.put(key, val-1);
                arr.add(key);
                permutate(idx+1, n , arr, out, map);
                map.put(key, val);
                arr.remove(arr.size()-1);
            }

        }
    }
}
