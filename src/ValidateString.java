import java.util.Stack;

public class ValidateString {

    public static void main(String[] args) {
        ValidateString o = new ValidateString();
        System.out.println(o.minRemoveToMakeValid("lee(t(c)o)de)"
        ));
    }
    static class Pair {
        int idx;
        char c;

        public Pair(int idx, char c){
            this.idx=idx;
            this.c=c;
        }
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        int i=0;
        for(char c: s.toCharArray()){
            if(c==')'){
                if(!stack.isEmpty() && stack.peek().c=='('){
                    stack.pop();
                } else {
                    stack.push(new Pair(i,c));
                }
            } else if(c=='('){
                stack.push(new Pair(i,c));
            }
            i++;
        }
        int idx = -1;
        if(!stack.isEmpty()){
            idx = stack.pop().idx;
        }
        StringBuilder sb = new StringBuilder();
        for(i=s.length()-1;i>=0;i--){
            if(idx!=i)
                sb.insert(0,s.charAt(i));
            else {
                if(!stack.isEmpty()){
                    idx = stack.pop().idx;
                } else{
                    idx = -1;
                }
            }

        }
        return sb.toString();
    }
}
