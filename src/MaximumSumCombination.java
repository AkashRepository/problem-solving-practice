import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSumCombination {


    public static void main(String[] args) {
        MaximumSumCombination o = new MaximumSumCombination();
        System.out.println(o.solve(Arrays.<Integer>asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83)
                , Arrays.<Integer>asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83),10));
    }

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B, int C) {

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);

        pq1.addAll(A);
        pq2.addAll(B);

        int a1 = -1, b1 = -1;
        ArrayList<Integer> output = new ArrayList<>();

        while (C > 0 && !pq1.isEmpty() && !pq2.isEmpty()) {
            int a = pq1.remove();
            int b = pq2.remove();


            if (a1 == -1 && b1 == -1) {
                output.add(a + b);
                C--;
            } else {
                Integer[] temp = new Integer[]{a + b1, b + a1, a + b};
                Arrays.sort(temp, (x, y) -> y.compareTo(x));
                for (int i = 0; i < 3 && C != 0; i++) {
                    output.add(temp[i]);
                    C--;
                }

            }
            a1 = a;
            b1 = b;

        }
        return output;
    }
}
