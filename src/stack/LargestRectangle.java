package stack;

import java.util.Stack;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int max = Integer.MIN_VALUE;

        int j = 0;
        while(j<n){
            while(!s.isEmpty() && heights[s.peek()]>heights[j]){
                int idx = s.pop();
                int val = heights[idx] * (s.isEmpty()?j:j-s.peek()-1);
                max = Math.max(max, val);
            }
            s.push(j++);
        }
        while(!s.isEmpty()){
            int idx = s.pop();
            int val = heights[idx] * (s.isEmpty()?j:j-s.peek()-1);
            max = Math.max(max, val);
        }
        return max;
    }
}
