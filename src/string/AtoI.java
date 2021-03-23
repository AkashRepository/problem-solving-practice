package string;

public class AtoI {

    public int myAtoi(String A) {
        int out = 0;
        int n = A.length();
        int l = 0;
        int s = 0;
        while(s<n && A.charAt(s)==' '){
            s++;
        }
        boolean sign = false;
        if(s<n && A.charAt(s)=='-'){
            sign = true;
            s++;
        } else
        if(s<n && A.charAt(s)=='+'){
            sign = false;
            s++;
        }
        while(s<n && A.charAt(s)>='0' && A.charAt(s)<='9'){

            int value = A.charAt(s)-'0';
            // System.out.println(value);
            if (out > Integer.MAX_VALUE / 10
                    || (out == Integer.MAX_VALUE / 10
                    && value > 7))
            {
                if (sign)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            out = out*10 + value;
            s++;
        }

        return sign?-1*out:out;
    }
}
