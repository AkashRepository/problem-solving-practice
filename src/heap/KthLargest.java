package heap;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    int min = -1;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int a: nums){
            minHeap.offer(a);
        }
        while(minHeap.size()>k){
            minHeap.poll();
        }
    }

    public int add(int val) {

        if(this.minHeap.size() < k){
            this.minHeap.offer(val);
        } else if(val > this.minHeap.peek()){
            this.minHeap.offer(val);
            this.minHeap.poll();
        }

        return this.minHeap.peek();
    }
}
