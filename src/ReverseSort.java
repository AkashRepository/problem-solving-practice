import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseSort {

    private static void reverse(int[] arr, int i, int j){
        while(i<j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while(tc-->0){
            Integer l = Integer.parseInt(br.readLine().trim());
            String[] arrStr = br.readLine().trim().split(" ");
            int n = arrStr.length;
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            int out = 0;
            for(int i=0;i<n-1;i++){
                int min = Integer.MAX_VALUE;
                int minidx = -1;
                for(int j=i;j<n;j++) {
                    if(min > arr[j]) {
                        min = arr[j];
                        minidx = j;
                    }
                }
                out  = out + minidx - i + 1;
                reverse(arr, i, minidx);
            }
            System.out.println(out);
        }
        br.close();
    }
}