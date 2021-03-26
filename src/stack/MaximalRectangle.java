package stack;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int[] arr = new int[n];

        int j = 0;
        while(j<m){
            for(int i=0;i<n;i++){
                if(matrix[j][i]=='1'){
                    arr[i]=arr[i]+1;
                } else {
                    arr[i]=0;
                }
            }
            // System.out.println(Arrays.toString(arr));
            int i = 0;
            while(i<n){
                while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                    int idx = s.pop();
                    int value = arr[idx]*(s.isEmpty()?i:i-s.peek()-1);
                    max = Math.max(max, value);
                }
                s.push(i++);
            }
            while(!s.isEmpty()){
                int idx = s.pop();
                int value = arr[idx]*(s.isEmpty()?n:n-s.peek()-1);
                max = Math.max(max, value);
            }
            j++;
        }
        return max;



    }
}
