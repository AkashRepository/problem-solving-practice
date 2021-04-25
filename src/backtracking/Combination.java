package backtracking;

import java.util.ArrayList;

public class Combination {

    public static void main(String[] args) {
        Combination o = new Combination();
        System.out.println(o.combine(2, 1));
    }

    private void combinationHelper(int a, int n, int k, ArrayList<Integer> arr){
        if(arr.size()>k)
            return;
        if(arr.size()==k){
            out.add(new ArrayList<>(arr));
            return;
        }
        for(int i=a;i<=n;i++){
            arr.add(i);
            combinationHelper(i+1, n, k, arr);
            arr.remove(arr.size()-1);
        }

    }

    ArrayList<ArrayList<Integer>> out = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        combinationHelper(1, A, B, new ArrayList<>());
        return out;
    }
}
