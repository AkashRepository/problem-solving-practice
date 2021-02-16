import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    public static void main(String[] args) {
        PermutationString o = new PermutationString();
        System.out.println(o.letterCasePermutation("c"));
        System.out.println(o.letterCasePermutation("C"));
        System.out.println(o.letterCasePermutation("dq23f32rf2"));
    }

    private void permutation(int i, StringBuilder sb, List<String> out, int n){
        if(i>n)
            return;

        if(i==n){
            out.add(sb.toString());
            return;
        }
        if(Character.isDigit(sb.charAt(i))){
            permutation(i+1,sb, out, n);
        } else {
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if(Character.isUpperCase(sb.charAt(i)))
                sb2.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            else
                sb2.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

            permutation(i+1,sb, out, n);
            permutation(i+1,sb2, out, n);
        }
    }

    public List<String> letterCasePermutation(String S) {
        int i = 0;
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder(S);
        permutation(i, sb, out,S.length());
        return out;
    }
}
