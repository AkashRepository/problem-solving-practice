package hashing;

import java.util.HashMap;

public class Fractions {

    private void divide(long a, long b, StringBuilder sb, boolean f, HashMap<String, Integer> m, int t){
        if(a==0)
            return;
        if(b==0)
            return;
        if(m!=null){
            if(m.containsKey(a+"-"+b)){
                int idx = sb.lastIndexOf(".");
                // System.out.println(m.toString());
                sb.insert(idx+1+m.get(a+"-"+b),"(");
                sb.append(")");
                return;
            }
            m.put(a+"-"+b, t); //2-3, 20-3
        }
        // System.out.println(a+"-"+b);
        if(a>=b){
            long rem = a%b;
            long q = a/b;
            sb.append(q); //6
            divide(rem, b, sb, f, m, t+1);
            return;
        }
        if(!f){
            f = true;
            if(sb.length()==0)
                sb.append("0.");
            else
                sb.append(".");
            m = new HashMap<>();
            t = 0;
            m.put(a+"-"+b, 0); //2-3
        }
        a=a*10;
        while(a<b){
            t++;
            a=a*10;sb.append("0");
        }
        divide(a, b, sb, f, m, t);
    }

    public String fractionToDecimal(int A, int B) {
        if(A==0)
            return "0";
        long a = A;
        long b = B;
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if((a<0 && b>0) || (a>0 && b<0)){
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        divide(a%b, b, sb, false, null, 0);
        return sb.toString();
    }
}
