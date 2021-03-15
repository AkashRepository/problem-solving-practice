package linkedlist;

public class ProductTwoNumbersLinkedList {

    public static void main(String[] args) {
        ProductTwoNumbersLinkedList o =new ProductTwoNumbersLinkedList();
        System.out.println(o.multiply("21","13")); // 63 21 84
    }

    private void insert(StringBuilder sb, int i, int j,String num1,String num2){
        int b = 0;
        while(j>=0){
            int val2 = (int)(num2.charAt(j) - '0');
            int carry = 0;
            StringBuilder s = new StringBuilder();
            for(int ii=i,a=0;ii>=0;ii--,a++){
                int val1 = (int)(num1.charAt(ii) - '0');

                int product = val1*val2 + carry;
                s.setCharAt(0,(char)(product%10 + '0'));
                carry = product/10;

            }
            while(carry!=0){
                s.setCharAt(0,(char)((carry%10)+ '0'));
                carry = carry/10;
            }
            int size = s.length()-1;
            while(size>=0){
                int prev = 0;
                if(sb.length()>0 && sb.length()-1<=size){
                    prev = (int)(sb.charAt(size)-'0');
                    int x = prev + (int)(s.charAt(size)-'0') + carry;
                    sb.setCharAt(size, (char) (x%10+'0'));
                    carry = x/10;
                } else {
                    int x = prev + (int)(s.charAt(size)-'0') + carry;
                    sb.setCharAt(0, (char) (x%10+'0'));
                    carry = x/10;
                }
                size--;
            }
            while(carry!=0){
                sb.setCharAt(0,(char)((carry%10)+ '0'));
                carry = carry/10;
            }
            j--;
            b++;
        }
    }

    public String multiply(String num1, String num2) {
        int i=num1.length()-1, j=num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        if(i>=j){
            insert(sb, i, j, num1, num2);
        } else {
            insert(sb, j, i, num2, num1);
        }
        return sb.toString();
    }

//         while(i>=0 && j>=0){
//             int val1 = (int)(num1.charAt(i) - '0');
//             int val2 = (int)(num2.charAt(j) - '0');
//             int product = val1*val2 + carry;
//             sb.insert(0,(char)((product)%10 + '0'));
//             carry = product/10;
//             i--;j--;
//         }
//         while(i>=0){
//             int val1 = (int)(num1.charAt(i) - '0');
//             int product = val1 + carry;
//             sb.insert(0,(char)((product)%10 + '0'));
//             carry = product/10;
//             i--;
//         }

//         while(j>=0){
//             int val2 = (int)(num2.charAt(j) - '0');
//             int product = val2 + carry;
//             sb.insert(0,(char)((product)%10 + '0'));
//             carry = product/10;
//             j--;
//         }
//         if(carry!=0){
//             sb.insert(0,(char)(carry + '0'));
//         }
}
