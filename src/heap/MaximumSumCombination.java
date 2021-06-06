package heap;

import java.util.*;

public class MaximumSumCombination {


    public static void main(String[] args) {
        MaximumSumCombination o = new MaximumSumCombination();
        System.out.println(o.solve(Arrays.<Integer>asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83)
                , Arrays.<Integer>asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83),10));
    }

    static class Heap {
        int sum;
        int i;
        int j;

        public Heap(int sum, int i, int j){
            this.sum=sum;
            this.i=i;
            this.j=j;
        }

        public boolean equals(Object o){
            if(o==null)
                return false;
            if(!(o instanceof Heap))
                return false;
            Heap h = (Heap)o;
            return this.i == h.i && this.j == h.j;
        }

        public int hashCode(){
            return Integer.valueOf(i).hashCode()*Integer.valueOf(j)*13;
            // return Objects.hash(i,j);
        }
    }

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B, int C) {

        PriorityQueue<Heap> pq = new PriorityQueue<>((a,b) -> {
            if(b.sum==a.sum){
                return Integer.compare(b.i,a.i)==0?Integer.compare(b.j,b.j):Integer.compare(b.i,a.i);
            }
            return Integer.compare(b.sum,a.sum);
        });
        ArrayList<Integer> output = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        HashSet<Heap> hs = new HashSet<>();
        int i = A.size()-1;
        int j = B.size()-1;
        pq.add(new Heap(A.get(i)+B.get(j), i, j));
        // for(int a: A){
        //     for(int b: B){
        //         pq.add(new Heap(a+b, i, j));
        //     }
        // }

        while(C-->0){
            Heap h = pq.poll();
            output.add(h.sum);
            i = h.i-1;
            j = h.j;
            if(i>=0 && j>=0){
                Heap a = new Heap(A.get(i)+B.get(j), i, j);
                if(hs.add(a)){
                    pq.add(a);
                }
            }
            i = h.i;
            j = h.j-1;
            if(i>=0 && j>=0){
                Heap b = new Heap(A.get(i)+B.get(j), i, j);
                if(hs.add(b)){
                    pq.add(b);
                }
            }

        }


        return output;
    }
}
