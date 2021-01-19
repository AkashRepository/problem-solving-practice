import java.util.HashMap;
import java.util.Map;

public class ReduceToZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0, n=nums.length, max = -1;
        for(int a:nums){
            sum+=a;
        }
        int rem = sum - x;
        sum=0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==rem)
                max = i+1;
            m.putIfAbsent(sum, i);
            if(m.containsKey(sum - rem)){
                max = Math.max(i - m.get(sum - rem),max);
            }
        }
        return max==-1?max:n-max;
    }

    public static void main(String[] args) {
        ReduceToZero o = new ReduceToZero();
        System.out.println(o.minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}
        ,134365));
    }

}
