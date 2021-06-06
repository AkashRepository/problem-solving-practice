package array;

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        int length = 1;
        int n = arr.length;
        int max = 1;
        boolean down = false;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1] ){
                if(down){
                    length++;
                } else {
                    length = 2;
                }
                max = Math.max(max, length);
                down = false;
            } else if(arr[i]<arr[i-1]){
                if(down){
                    length=2;
                } else {
                    length++;
                }
                max = Math.max(max, length);
                down = true;
            } else {
                length = 1;
                down = false;
            }
        }
        return max;
    }
}
