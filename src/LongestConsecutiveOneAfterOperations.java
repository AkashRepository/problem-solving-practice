import java.util.ArrayList;

public class LongestConsecutiveOneAfterOperations {

    public int solve(ArrayList<Integer> A, int B) {

        int[] arr = new int[A.size()];
        int a=0, b=1;
        arr[0]=A.get(0);
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1] + A.get(i);
        }
        int max = 0;
        for(;b<arr.length;b++){
            int val = 0;
            if(a-1>=0)
                val = arr[a-1];
            int num = arr[b] - val;
            if((b-a+1) > num + B){
                a++;
            } else {
                max = Math.max(max, b-a+1);
            }
        }
        return max;

    }
}
