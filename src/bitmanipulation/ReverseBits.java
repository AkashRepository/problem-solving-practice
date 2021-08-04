package bitmanipulation;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits o = new ReverseBits();
        System.out.println(o.reverse(0L));//11
    }

    public long reverse(long a) {
        long binary = 0;
        for(int i=31;i>=0;i--, a=a>>1){
            if((a & 1) == 1)
                binary = binary + (1L<<i);
        }
        return binary;
    }
}
