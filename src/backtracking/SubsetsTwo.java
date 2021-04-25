package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {

    public static void main(String[] args) {
        SubsetsTwo o = new SubsetsTwo();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(12);
        a.add(13);
        System.out.println(o.subsets(a));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        subset(0, nums, n, new ArrayList<>(), out);
        return out;
    }

    private void subset(int idx, int[] nums, int n, List<Integer> arr, List<List<Integer>> out) {
        out.add(new ArrayList<>(arr));
        for(int i=idx;i<n;i++){
            if(i>idx && nums[i]==nums[i-1])
                continue;
            arr.add(nums[i]);
            subset(i+1, nums, n, arr, out);
            arr.remove(arr.size()-1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        out.add(new ArrayList<>());
        for (Integer a : A) {
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (ArrayList<Integer> o : out) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(o);
                temp.add(a);
                arr.add(temp);
            }
            out.addAll(arr);//[],[12],
        }
        return out;

    }
}
