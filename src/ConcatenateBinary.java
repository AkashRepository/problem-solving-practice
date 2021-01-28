public class ConcatenateBinary {
    int mod = 1_000_000_007;

    public int concatenatedBinary(int n) {
        if(n==1)
            return 1;
        int out = 0;
        int k = 1;
        for(int i=n;i>=1;i--){
            int t = i;
            while(t>0){
                if((t&1)==1)
                    out = (out + k)%mod;
                t=t>>1;
                k = (k * 2)%mod;
            }
        }
        return out%mod;
    }

    public static void main(String[] args) {
        ConcatenateBinary o =new ConcatenateBinary();

        System.out.println(o.concatenatedBinary(12));
    }
}
