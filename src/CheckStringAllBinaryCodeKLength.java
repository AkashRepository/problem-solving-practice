public class CheckStringAllBinaryCodeKLength {

    public static void main(String[] args) {
        CheckStringAllBinaryCodeKLength o = new CheckStringAllBinaryCodeKLength();
//        System.out.println(Arrays.toString(o.getAllBinaryCombinations(5)));
        System.out.println((o.hasAllCodes("00110110",2)));
        System.out.println((o.hasAllCodes("0000000001011100",5)));
        System.out.println((o.hasAllCodes("0110",2)));
    }

    private int getValue(int i, int j,String s){
        int start = j;
        int c = 0, val = 0;
        while(start>=i){
            if(s.charAt(start)=='1'){
                val = val + (int)Math.pow(2, c);
            }
            start--;
            c++;
        }
        return val;
    }

    public boolean hasAllCodes(String s, int k) {
        int n = (int)Math.pow(2,k);
        int l = s.length();
        if(k>l){
            return false;
        }
        boolean[] arr = new boolean[n];

        int val = getValue(0, k-1, s);
        arr[val]=true;
        for(int i=k;i<l;i++){
            val = val<<1;
            if(s.charAt(i)=='1'){
                val = val + 1;
            }
            if(s.charAt(i-k)=='1'){
                val = val - (int)Math.pow(2,k);
            }
            arr[val]=true;
        }
        for(boolean f: arr){
            if(!f)
                return f;
        }
        return true;

    }



    private String[] getAllBinaryCombinations(int k) {
        int n = (int) Math.pow(2, k);
        String[] arr = new String[n];
        StringBuilder sb = null;
        int c = 0;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0, t = 0; j < k; j++) {
                sb.append((i & (1 << t))==0?0:1);
                t++;
            }
            arr[c++] = sb.toString();
        }
        return arr;
    }
}
