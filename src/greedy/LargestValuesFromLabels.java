package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestValuesFromLabels {

    public int largestValuesFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>(); // to keep track on number of occurrences of labels
        int n = values.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{values[i], labels[i]}); // to keep track on highest values of labels
        }
        int times = 0;
        int sum = 0;
        while(!pq.isEmpty() && times < num_wanted){
            int[] val = pq.poll(); // get the highest label
            int count  = map.getOrDefault(val[1], 0);
            if(count<use_limit){ // check if the count of this specific label is within the limit
                times++; // increment the times which we considered the label to be added
                sum = sum + val[0];
            }
            map.put(val[1], count+1); // increment the counter
        }
        return sum;
    }
}
