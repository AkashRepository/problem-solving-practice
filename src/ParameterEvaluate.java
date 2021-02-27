import java.util.Stack;

public class ParameterEvaluate {

    public static void main(String[] args) {
        ParameterEvaluate o = new ParameterEvaluate();
        System.out.println(o.scoreOfParentheses("(((()())))"));
    }

    public int scoreOfParentheses(String S) {
        int out = 0;
        Stack<Integer> s = new Stack<>();
        int k = 0, m = 0;
        int i = 0;
        while (i < S.length()) {
            while (i < S.length() && S.charAt(i) == '(') {
                s.push(0);
                i++;
            }
            m = 0;
            while(i<S.length() && !s.isEmpty() &&  S.charAt(i) == ')' && s.peek()!=0){
                m = m + s.pop();
            }
            k = 0;
            while(i<S.length() && !s.isEmpty() &&  S.charAt(i) == ')' && s.peek()==0){
                k++;
                i++;
                s.pop();
            }
            if(m!=0 && k!=0)
                s.push(m*(int)Math.pow(2,k));
            else if(k!=0)
                s.push((int)Math.pow(2,k-1));
            else if(m!=0)
                s.push(m);
        }
        while(!s.isEmpty())
            out = out + s.pop();
        return out;
    }
}
