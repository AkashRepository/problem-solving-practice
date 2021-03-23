package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsMatrix {

    public static void main(String[] args) {
        KWeakestRowsMatrix o = new KWeakestRowsMatrix();
        System.out.println(Arrays.toString(o.kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}}, 3)));
    }

    private int search(int[] arr) {
        int i = 0, j = arr.length - 1;
        if(arr[i]!=1){
            return -1;
        }
        if(arr[j]!=0){
            return arr.length;
        }
        while (i < j) {
            int mid = (i + j) / 2;

            if(i==mid)
                return i;
            if (arr[mid] == 1) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int min = Integer.MAX_VALUE;
        PriorityQueue<int[]> l = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int i=0;
        for(int[] a: mat){
            int val = search(a);
            l.add(new int[]{val,i++});
        }
        int[] out = new int[k];
        i=0;
        while(k-->0 && !l.isEmpty()){
            out[i++] = l.poll()[1];
        }
        return out;
    }
}
