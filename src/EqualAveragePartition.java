import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualAveragePartition {

    private boolean present(int idx, int tempSum, int tempNum, int n, boolean[][][] arr,
                            List<Integer> out, ArrayList<Integer> A){

        if(tempNum==0)
            return tempSum==0;
        if(idx>=n)
            return false;


        if(!arr[idx][tempSum][tempNum])
            return false;

        if(A.get(idx)<=tempSum){
            out.add(idx);
            if(present(idx+1, tempSum-A.get(idx), tempNum - 1, n, arr, out, A))
                return true;
            out.remove(out.size()-1);
        }

        if(present(idx+1, tempSum, tempNum, n, arr, out, A))
            return true;

        arr[idx][tempSum][tempNum] = false;
        return false;

    }

    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        int n = A.size();
        int sum = 0;
        for(Integer a : A){
            sum = sum + a;
        }
        boolean[][][] arr = new boolean[n][sum+1][n];
        ArrayList<Integer> out = new ArrayList<>();
        Collections.sort(A);
        for(int i=0;i<n;i++)
            for(int j=0;j<=sum;j++)
                for(int k=0;k<n;k++)
                    arr[i][j][k] = true;

        /*
         *  avg = total_sum / number_of_elements
         *  temp_avg = j / i
         *  avg = temp_avg
         *  total_sum / number_of_elements = j / i;
         *
         */
        ArrayList<Integer> other = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(i*sum % n != 0)
                continue;
            int j = (int)(i*sum)/n;
            if(present(0, j, i, n, arr, out, A)){

                ArrayList<Integer> another = new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(!out.contains(k))
                        other.add(A.get(k));
                    else
                        another.add(A.get(k));
                }
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                res.add(another);
                res.add(other);
                return res;
            }
        }
        return new ArrayList<ArrayList<Integer>>();

    }
}
