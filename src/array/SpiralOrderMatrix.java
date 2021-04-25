package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        SpiralOrderMatrix o = new SpiralOrderMatrix();
        System.out.println(o.spiralOrder(Arrays.asList(Arrays.asList(353,330,147),
           Arrays.asList(26, 214, 3  ),
           Arrays.asList(353, 330, 147),
           Arrays.asList(229, 302, 276),
           Arrays.asList(125, 335, 284),
                Arrays.asList(290, 228, 30))));
    }

    public ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
        ArrayList<Integer>  arr = new ArrayList<>();
        int m = A.size();
        int n = A.get(0).size();
        int count = m*n;
        if(m==1 && n==1){
            arr.add(A.get(0).get(0));
            return arr;
        } else if(m==1){
            arr.addAll(A.get(0));
            return arr;
        } else if(n==1) {
            for(List<Integer> a : A){
                arr.add(a.get(0));
            }
            return arr;
        }
        int len = Math.min((m&1)==0?m/2:m/2+1, (n&1)==0?n/2:n/2+1);

        for(int i = 0; i < len && arr.size()<count;i++){
            for(int j=i, k = i;k<n-i && arr.size()<count;k++){
                arr.add(A.get(j).get(k));
            }
            for(int j=i+1, k=n-1-i;j<m-i && arr.size()<count;j++){
                arr.add(A.get(j).get(k));
            }
            for(int j=m-1-i, k=n-2-i;k>=i && arr.size()<count;k--){
                arr.add(A.get(j).get(k));
            }
            for(int j=m-2-i, k=i;j>i && arr.size()<count;j--){
                arr.add(A.get(j).get(k));
            }
        }

        return arr;
    }
}
