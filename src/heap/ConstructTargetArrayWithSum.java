package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructTargetArrayWithSum {

    public static void main(String[] args) {
        ConstructTargetArrayWithSum o = new ConstructTargetArrayWithSum();
        System.out.println(o.isPossible(new int[]{9,3,5}));
    }

    public boolean isPossible(int[] target) {
        Queue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int n = target.length;
        long sum = 0l;
        if(n==1)
            return target[0]==1;
        for(int a: target){
            sum = sum + a;
            q.add(a);
        }
        while(!q.isEmpty() && q.peek()>0 && q.peek()!=1){
            int highest = q.poll();
            int next = q.peek();
            int rest = (int)(sum - highest);
            if(rest<=0)
                return false;
            int numOfTimes = (highest - next)/rest;
            if(numOfTimes<1)
                numOfTimes = 1;
            sum = sum - numOfTimes*rest;
            highest = highest - numOfTimes*rest;
            if(highest<=0)
                return false;
            q.add(highest);
        }


        return q.peek()==1;
    }
}
