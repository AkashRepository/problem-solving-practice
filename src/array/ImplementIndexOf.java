package array;

public class ImplementIndexOf {

    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if(n==0){
            return 0;
        }
        int[] lps = lps(n, needle);

        int i = 0, j = 0;
        while(j<m){
            if(haystack.charAt(j) == needle.charAt(i)){
                i++;
                j++;
            }
            if(i==n){
                return j-i;
            }
            if(i<n && j<m && haystack.charAt(j) != needle.charAt(i)) {
                if(i!=0){
                    i = lps[i-1];
                } else {
                    j++;
                }
            }
        }
        return -1;
    }

    private int[] lps(int n, String needle){
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while(i<n){
            if(needle.charAt(i) == needle.charAt(len)){
                lps[i++] = ++len;
            } else {
                if(len!=0){
                    len = lps[len-1];
                } else {
                    lps[i++] = len;
                }
            }
        }
        return lps;
    }
}
