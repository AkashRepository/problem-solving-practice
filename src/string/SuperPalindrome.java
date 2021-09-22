package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SuperPalindrome {


    private long countBit(long n){
        long b = 0;
        while(n!=0){
            n = n/10;
            b++;
        }
        return b;
    }

    private long digitAt(long n, long i){
        long out = 0;
        while(i-->0){
            out = n%10;
            n = n/10;
        }
        return out;
    }

    private long generatePalindromeEven(int n){
        StringBuilder sb = new StringBuilder().append(n);
        sb.reverse().insert(0,n);
        return Long.parseLong(sb.toString());
    }
    private long generatePalindromeOdd(int n, int j){
        StringBuilder sb = new StringBuilder().append(n).append(j);
        sb.reverse().insert(0,n);
        return Long.parseLong(sb.toString());
    }

    private boolean isPalindrome(long t){
        long i = 1;
        long j = countBit(t);
        while(i<=j){
            long a = digitAt(t,i);
            long b = digitAt(t,j);
            if(a!=b)
                break;
            i++;
            j--;
        }
        return i>j;
    }


    public int superpalindromesInRange(String left, String right) {
        // 4 9 16 36 121
        int out = 0;
        long leftVal = Long.parseLong(left);
        long rightVal = Long.parseLong(right);
        for(int i=1 ; i <= 10000; i++){
            long t = generatePalindromeEven(i);
            if(t*t>=leftVal && t*t<=rightVal && isPalindrome(t*t)){
                // System.out.println(t*t);
                out++;
            }
            for(int j=1;i>j && j<10;j++){
                t = generatePalindromeOdd(i,j);
                if(t*t>=leftVal && t*t<=rightVal && isPalindrome(t*t)){
                    // System.out.println(t*t);
                    out++;
                }
            }
            if(i<10){
                t = i;
                if(t*t>=leftVal && t*t<=rightVal && isPalindrome(t*t)){
                    // System.out.println(t*t);
                    out++;
                }
            }
        }


        return out;
    }

    public static void main(String[] args) {
        SuperPalindrome o = new SuperPalindrome();
//        System.out.println(o.generatePalindromeEven(11));
//        System.out.println(o.generatePalindromeEven(23));
//        System.out.println(o.generatePalindromeEven(52));
//        System.out.println(o.generatePalindromeEven(99));
//        System.out.println(o.generatePalindromeEven(9));
//        System.out.println(o.generatePalindromeOdd(11,7));
        System.out.println(o.generatePalindromeOdd(1,3));
//        System.out.println(o.generatePalindromeOdd(99,1));
//        System.out.println(o.generatePalindromeOdd(122,0));
        System.out.println(o.superpalindromesInRange("40000000000000000",
                "50000000000000000"));
    }
}
