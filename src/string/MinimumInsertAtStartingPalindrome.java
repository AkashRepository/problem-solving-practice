package string;

import java.util.Arrays;

public class MinimumInsertAtStartingPalindrome {

    public static void main(String[] args) {
        MinimumInsertAtStartingPalindrome o = new MinimumInsertAtStartingPalindrome();
        System.out.println(o.solve("AACECAAAA"));
    }

    public int solve(String A) {
        int n = A.length();

        StringBuilder sb = new StringBuilder(A);

        String s = A + "$" + sb.reverse();

        int[] lps = buildLps(s);

        return n - lps[lps.length-1] -1;
    }
// lps is longest prefix which is also suffix using KMP
    private int[] buildLps(String s) {
        int n = s.length();
        // AACECAAAA$AAAACECAA

        int[] lps = new int[n];
        int j = 0;
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(j)){
                lps[i] = j;
                i++;
                j++;
            } else if(j>0){
                j = lps[j-1];
            } else {
                lps[i] = 0;
                i++;
            }
            System.out.println(Arrays.toString(lps));
        }
        return lps;
    }
}
