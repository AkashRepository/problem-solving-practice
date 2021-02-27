import java.util.Arrays;
import java.util.List;

public class MaximumProductSubarray {

    public int maxProduct(final List<Integer> A) {
        if(A.size()==1)
            return A.get(0);
        int out = A.get(0);
        int min =0;
        int max =0;
        for(int i=0;i<A.size();i++){
            int a = A.get(i);
            if(a<0){
                int temp = min;

                min = Math.min(a,max*a);
                max = Math.max(a,temp*a);
            } else if(a==0){
                min = 0;
                max = 0;
            } else {
                max = Math.max(a, max*a);
                min = Math.min(a, min*a);
            }
            out = Math.max(out, max);
        }
        return out;

    }
}
