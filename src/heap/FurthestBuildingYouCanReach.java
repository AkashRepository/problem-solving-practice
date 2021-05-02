package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int i = 0;
        int out = 0;
        int sum = 0;
        int[] arr = new int[n];
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(i=1;i<n;i++){
            if(heights[i]>heights[i-1]){
                int diff = heights[i] - heights[i-1];
                if(minHeap.size()<ladders){
                    minHeap.add(diff);
                } else if(!minHeap.isEmpty() && minHeap.peek() < diff) {
                    sum = sum + minHeap.poll();
                    minHeap.add(diff);
                } else {
                    sum = sum + diff;
                }
            }
            if(sum>bricks){
                break;
            }
            out  = i;
        }
        return out;
    }
}
