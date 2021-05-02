package array;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPermutation {

    //normal output
    public ArrayList<Integer> findPerm(final String A, int B) {
        int n = A.length();
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(char c: A.toCharArray()){
            if(c=='D')
                count++;
        }
        if(A.charAt(0)=='I'){
            count++;
        }
        int min = count;
        int max = count+1;
        if(A.charAt(0)=='I'){
            arr.add(min--);
            arr.add(max++);
        } else {
            arr.add(max++);
            arr.add(min--);
        }
        for(int i=1;i<n;i++){
            if(A.charAt(i)=='I'){
                arr.add(max++);
            } else {
                arr.add(min--);
            }
        }
        return arr;
    }

    // for sorted order output
    public int[] findPermutation(String s) {
        int[] arr = new int[s.length() + 1];
        int min = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                arr[i] = min++;
                int j = i - 1;
                while (j >= 0 && s.charAt(j) == 'D') {
                    arr[j--] = min++;
                }
            }
        }
        arr[n] = min++;
        int j = n - 1;
        while (j >= 0 && s.charAt(j) == 'D') {
            arr[j--] = min++;
        }
        return arr;
    }
}
