public class LongestPalindromeSubstring {

    int max = 1;
    int start = 0;
    int end = 0;

    public String longestPalindrome(String A) {
        int max = 1;// one letter is the minimum palindrome
        int n = A.length();
        for(int i=0;i<n-1;i++){
            getIndexTillPalindrome(A, i, 0);
            getIndexTillPalindrome(A, i, -1);
        }
        return A.substring(start, end+1);

    }

    private void getIndexTillPalindrome(String a, int idx, int evenOdd){
        int i = idx + evenOdd, j = idx+1;
        while(i>=0 && j<a.length() && a.charAt(i)==a.charAt(j)){

            if(max < j-i+1){
                max = j-i+1;
                start = i;
                end = j;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring o = new LongestPalindromeSubstring();

        System.out.println(o.longestPalindrome("abbd"));
    }
}
