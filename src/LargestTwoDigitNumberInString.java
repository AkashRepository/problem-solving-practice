public class LargestTwoDigitNumberInString {


    public static void main(String[] args) {


        String s = "293691263";

        int max = Integer.MIN_VALUE;
        for(int i=1;i<s.length();i++){
            int second = (s.charAt(i) - '0');
            int first = (s.charAt(i-1) - '0') * 10;
            max = Math.max(max, first + second);
        }
        System.out.println(max);


    }
}
