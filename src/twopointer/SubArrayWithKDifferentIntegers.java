package twopointer;

import java.util.HashMap;

public class SubArrayWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int c = 0;

        HashMap<Integer, Integer> m = new HashMap<>();
        int i=0,j=0;
        while(j<n && i<n){
            m.put(A[j], m.getOrDefault(A[j], 0)+1);

            while(m.size()>K){
                m.put(A[i], m.get(A[i])-1);
                if(m.get(A[i])<=0){
                    m.remove(A[i]);
                }
                i++;
            }
            int prev = i;
            while(i<=j && m.size()==K) {
                m.put(A[i], m.get(A[i])-1);
                if(m.get(A[i])<=0){
                    m.remove(A[i]);
                }
                i++;
                c++;
            }

            while(prev!=i){
                i--;
                m.put(A[i], m.getOrDefault(A[i], 0)+1);
            }
            i = prev;
            j++;

        }
        return c;
    }
}
