import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequency {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
        Map<Integer, Integer> m = new HashMap<>();
        for(int i: nums){
            m.put(i, m.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        int[] out = new int[k];
        int t = k-1;
        while(k>0){
            out[t - k + 1] = pq.poll()[0];
            k--;
        }
        return out;
    }


}
