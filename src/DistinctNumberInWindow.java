import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DistinctNumberInWindow {

    public static void main(String[] args) {
        DistinctNumberInWindow o =new DistinctNumberInWindow();
        System.out.println(o.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3));
    }

    public ArrayList<Integer> dNums(List<Integer> A, int B) {

        HashMap<Integer, Integer> m = new HashMap<>();

        ArrayList<Integer> out = new ArrayList<>();
        for(int i=0;i<B-1;i++){
            m.put(A.get(i), m.getOrDefault(A.get(i),0)+1);
        }
        for(int i=B-1;i<A.size();i++){
            m.put(A.get(i), m.getOrDefault(A.get(i),0)+1);
            if(i==B-1){
                out.add(m.size());
            } else {
                m.put(A.get(i-B), m.getOrDefault(A.get(i-B),0)-1);
                if(m.get(A.get(i-B))<=0){
                    m.remove(A.get(i-B));
                }
                out.add(m.size());
            }
        }
        return out;

    }
}
