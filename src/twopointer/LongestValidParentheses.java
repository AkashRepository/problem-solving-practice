package twopointer;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int max = 0, localCount = 0;
        int i=0, n = s.length();
        int left = 0, right = 0;
        for( i=0;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            } else {
                right++;
            }
            if(left==right){
                max=Math.max(max,2*left);
            } else if(right>left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for( i=n-1;i>0;i--){
            if(s.charAt(i)=='('){
                left++;
            } else {
                right++;
            }
            if(left==right){
                max=Math.max(max,2*right);
            } else if(left>right){
                left=0;
                right=0;
            }
        }
        return max;
    }
}
