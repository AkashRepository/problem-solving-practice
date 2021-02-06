import java.util.Arrays;

public class CandyMoreThanTheNeighbors {

    public int candy(int[] r) {
        // 1 3 2 1 5 3 1 9 2
        // 1 2 1 1 3 2 1 2 1
        int n = r.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int i=0;i<n-1;i++){
            if(r[i] < r[i+1]){
                arr[i+1] = arr[i]+1;
            }
        }
        for(int i=n-1;i>0;i--){
            if(r[i] < r[i-1]){
                arr[i-1] = Math.max(arr[i-1], arr[i]+1);
            }
        }
        // 1 0 2
        // 2 1 2
        int sum=0;
        for(int a: arr){
            sum+=a;
        }
        return sum;
    }
}
