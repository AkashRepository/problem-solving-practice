package string;

import java.util.Arrays;

public class KthPermutation {

    int count = 0;
    String out = "";
    private void combination(int idx, int A, int B, StringBuilder sb, boolean[] vi){
        if(idx>A)
            return;
        sb.append(idx);
        if(sb.length()==A){
            count++;
            if(count==B){
                out = sb.toString();
            }
        }
        vi[idx] = true;
        for(int i=1;i<=A;i++){
            if(!vi[i])
                combination(i,A,B,sb,vi);
        }
        vi[idx] = false;
        sb.setLength(sb.length()-1);
    }

    public String getPermutation(int A, int B) {

        boolean[] vi = new boolean[A+1];
        for(int i=1;i<=A;i++)
            combination(i,A,B, new StringBuilder(), vi);
        return out;
    }

    public static void main(String[] args) {
        KthPermutation o = new KthPermutation();
        System.out.println(o.getPermutation(3,4));
    }
}

