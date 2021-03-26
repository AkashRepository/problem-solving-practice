package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AdvanceShuffle {

    public static void main(String[] args) {
        AdvanceShuffle o = new AdvanceShuffle();
//        System.out.println(Arrays.toString(o.advantageCount2(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(o.advantageCount2(new int[]{
                12,24,8,32
}, new int[]{13,25,32,11})));
    }

    public int[] advantageCount2(int[] A, int[] B) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int n = A.length;
        int i = 0;
        for (int b : B) {
            pq.add(new int[]{b, i++});
        }
        Arrays.sort(A);
        int j = n-1;
        int[] arr = new int[n];
        for (int b : B) {
            int[] v = pq.poll();
            if(v[0]<A[j]){
                arr[v[1]] = A[j];
                A[j]=-1;
                j--;
            } else {
                arr[v[1]]=-1;
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]==-1){
                arr[i]=A[j--];
            }
        }
        return arr;
    }

    public int[] advantageCount(int[] A, int[] B) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = A.length;
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] arr = new int[n];
        int i = 0;
        for (int b : B) {

            Integer key = map.higherKey(b);
            if (key == null) {
                key = map.firstKey();
            }
            Integer val = map.get(key);
            if (val == 1) {
                map.remove(key);
            } else {
                map.put(key, val - 1);
            }
            A[i++] = key;
        }
        return A;
    }
}
