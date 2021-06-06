package string;

public class AddBinaryString {

    public static void main(String[] args) {
        AddBinaryString o = new AddBinaryString();
        System.out.println(o.addBinary("1010110111001101101000",
                "1000011011000000111100110"));
    }

    public String addBinary(String A, String B) {

        int lengthA = A.length();
        int lengthB = B.length();
        StringBuilder sb = new StringBuilder();
        if(lengthA > lengthB){
            int diff = lengthA - lengthB;

            while(diff-->0){
                sb.append('0');
            }
            B = sb.toString() + B;
        } else if(lengthB > lengthA){

            int diff = lengthB - lengthA;

            while(diff-->0){
                sb.append('0');
            }
            A = sb.toString() + A;
        }
        int carry = 0;

        int i = A.length();
        sb = new StringBuilder();
        while(i-->0){

            if(A.charAt(i)=='0' && B.charAt(i)=='0'){
                sb.insert(0, carry);
                carry = 0;
            } else if (A.charAt(i)=='1' && B.charAt(i)=='0'){
                if(carry==0){
                    sb.insert(0, '1');
                } else {
                    sb.insert(0,'0');
                }
            } else if(A.charAt(i)=='0' && B.charAt(i)=='1'){
                if(carry==0){
                    sb.insert(0, '1');
                } else {
                    sb.insert(0,'0');
                }
            } else  if(A.charAt(i)=='1' && B.charAt(i)=='1'){
                if(carry==0){
                    sb.insert(0, '0');
                    carry = 1;
                } else {
                    sb.insert(0,'1');
                }
            }
            i--;

        }
        if(carry==1){
            sb.insert(0,1);
        }
        return sb.toString();
    }
}
