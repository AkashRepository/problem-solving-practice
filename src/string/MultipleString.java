package string;

public class MultipleString {

    public static void main(String[] args) {
        MultipleString o = new MultipleString();
        System.out.println(o.multiply("00009999", "9999"));
    }

    public String multiply(String A, String B) {
        StringBuilder a = new StringBuilder(A).reverse();
        StringBuilder b = new StringBuilder(B).reverse();
        StringBuilder out = new StringBuilder();
        out = multiple(0, a, b, out, 0).reverse();
        int i = 0;
        while(i<out.length() && out.charAt(i)=='0'){
            out.deleteCharAt(i);
        }
        return out.toString();
    }
    // 78
    //  9

    private StringBuilder multiple(int i, StringBuilder a, StringBuilder b, StringBuilder out, int c) {
        if (i == a.length()) {
            return out;
        }
        int m = a.charAt(i) - '0';
        int carry = 0;
        StringBuilder prev = new StringBuilder();
        for (int j = 0; j < c; j++) {
            prev.append("0");
        }
        for (int j = 0; j < b.length(); j++) {
            int value = (b.charAt(j) - '0') * m + carry;
            prev.append(value % 10);
            carry = value / 10;
        }
        if(carry>0){
            prev.append(carry);
        }
        add(prev, out);
        return multiple(i + 1, a, b, prev, c + 1);
    }

    private void add(StringBuilder a, StringBuilder b) {
        int i = 0;
        int carry = 0;
        while (i < b.length()) {
            int aa = a.charAt(i) - '0';
            int bb = b.charAt(i) - '0';
            int value = aa + bb + carry;
            a.setCharAt(i, (char) (value % 10 + '0'));
            carry = value / 10;
            i++;
        }
        while (i < a.length()) {
            int aa = a.charAt(i) - '0';
            int value = aa + carry;
            a.setCharAt(i, (char) (value % 10 + '0'));
            carry = value / 10;
            i++;
        }
        if (carry > 0) {
            a.append(carry);
        }
    }
}
// 9999
// 9999
// 89991
//899910
//989901