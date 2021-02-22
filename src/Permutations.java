import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    private void swapping(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void permute(int[] nums, int i, int j, List<List<Integer>> out){
        if(i==j)
            out.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int ii=i;ii<=j;ii++){
            swapping(nums,ii,i);
            permute(nums,i+1,j,out);
            swapping(nums,ii,i);
        }
    }
    private void permute(int[] nums, int i, int j,List<Integer> list, List<List<Integer>> out, Map<Integer, Integer> m){
        if(i==j){
            out.add(new ArrayList<>(list));
            return;
        }
        // System.out.println(Arrays.toString(nums));
        for(int key : m.keySet()){
            if(m.get(key)>0){
                list.add(key);
                m.put(key,0);
                permute(nums, i+1, j,list, out, m);
                m.put(key,1);
                list.remove(list.size()-1);
            }
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        // permute(nums, 0, nums.length-1, out);
        Map<Integer, Integer> m = new HashMap<>();
        for(int a: nums){
            m.put(a, m.getOrDefault(a,0)+1);
        }
        permute(nums, 0, nums.length, new ArrayList<>(),out,m);
        return out;
    }
}
