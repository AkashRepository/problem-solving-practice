package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis o = new GenerateParenthesis();
        System.out.println(o.generateParenthesis(2));
        System.out.println(o.generateParenthesis(3));
        System.out.println(o.generateParenthesis(4));
    }

    private boolean check(String temp) {
        int o = 0;
        for (char c : temp.toCharArray()) {
            if (c == '(') {
                o = o + 1;
            }
            if (c == ')') {
                o = o - 1;
            }
            if (o < 0) {
                return false;
            }
        }
        return o == 0;
    }


    private void generate(int i, int n,int o, int c, StringBuilder temp, List<String> out){

        if(o<0 || c<0 || o>n/2 || c>n/2 || c>o)
            return;

        if(i==n){
            out.add(temp.toString());
        }
        temp.append('(');
        generate(i+1, n,o+1, c, temp, out);
        temp.deleteCharAt(temp.length()-1);

        temp.append(')');
        generate(i+1, n,o, c+1, temp, out);
        temp.deleteCharAt(temp.length()-1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        generate(0, 2*n, 0, 0, new StringBuilder(), out);
        return out;
    }

}
