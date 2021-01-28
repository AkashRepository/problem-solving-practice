public class SmallestStringGivenValue {

    public String getSmallestString(int n, int k) {
        char[] c = new char[n];
        int j = n - 1;
        int out = 0;

        int diff = k - j - 1;
        while (diff >= 0 && out!=k && j>=0) {
            if(diff<26) {
                out = out + diff + 1;
                c[j--] = (char) (diff + 'a');
            } else{
                out = out + 26;
                c[j--] = 'z';
            }
            diff = k - out - j - 1;
        }

        return new String(c);
    }

    public static void main(String[] args) {
        SmallestStringGivenValue o = new SmallestStringGivenValue();
        System.out.println(o.getSmallestString(5, 31));
    }
}
