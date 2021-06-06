package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateSortedArrayTwo {

    public static void main(String[] args) {
        RemoveDuplicateSortedArrayTwo o = new RemoveDuplicateSortedArrayTwo();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010));
        System.out.println(o.removeDuplicates(list));
        System.out.println(list);
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        int prev = 0;
        int count = 1;
        int n = a.size();
        //1 2 3 3 4 4 4 4 4
        //1 2 3 3 4
        for(int i=0;i<n-1;i++){
            if(a.get(i).equals(a.get(i + 1))){
                count++;
            } else {
                if(count>=2 ){
                    a.set(prev,a.get(i));
                    a.set(prev+1,a.get(i));
                    prev = prev+2;
                } else {
                    a.set(prev,a.get(i));
                    prev = prev+1;
                }
                count=1;
            }
        }
        if(count>=2 ){
            a.set(prev,a.get(n-1));
            a.set(prev+1,a.get(n-1));
            prev = prev+2;
        } else {
            a.set(prev,a.get(n-1));
            prev = prev+1;
        }
        return prev;
    }
}
