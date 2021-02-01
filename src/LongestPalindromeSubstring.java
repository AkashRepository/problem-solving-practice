public class LongestPalindromeSubstring {


    private int getMaxPalindromeLength(char[] c, int i, int j, int max){

        while(i>=0 && j<c.length && c[i]==c[j]){
            max=max+2;
            i--;
            j++;
        }
        return max;
    }

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length, str = 0, end = 1, max = 1;
        for(int i=0;i<n-1;i++){
            int localMax = getMaxPalindromeLength(c, i-1, i+1, 1);

            if(localMax > max){
                max = localMax;
                str = i - max/2;
                end = str + max;
            }

            localMax = getMaxPalindromeLength(c, i, i+1 , 0);
            if(localMax > max){
                max = localMax;
                str = i - max/2 + 1;
                end = str + max;
            }

        }

        return s.substring(str, end );
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring o = new LongestPalindromeSubstring();

        System.out.println(o.longestPalindrome("abbd"));
    }
}
