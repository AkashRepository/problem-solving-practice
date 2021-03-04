import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<String> generate(int i, int n, int o, int c, String temp, List<String> out) {
        if (o > n / 2 || c < 0 || c > n / 2 || o < 0 || c>o)
            return out;

        if (i == n || temp.length() == n) {
            out.add(temp);
            return out;
        }
        generate(i + 1, n, o + 1, c, temp + "(", out);

        generate(i + 1, n, o, c + 1, temp + ")", out);
        return out;
    }

    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        return generate(0, 2 * n, 0, 0, "", out);
    }

}
