import java.util.Arrays;

public class CountPrime {
    public int countPrimes(int n) {
        Boolean[] arr = new Boolean[n+1];
        arr[0] = false;
        arr[1] = false;

        Arrays.fill(arr, true);

        for(int i=2;i*i<=n;i++){
            if(arr[i]){
                for(int j=i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }

        return (int) Arrays.stream(arr).filter(s -> s).count();
    }

    public static void main(String[] args) {
        CountPrime o =new CountPrime();
        System.out.println(o.countPrimes(10));
    }
}
