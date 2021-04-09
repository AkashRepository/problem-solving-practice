package hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> A) {

        Set<Integer> map = new HashSet<Integer>();

        for(int a: A){
            map.add(a);
        }
        int max = Integer.MIN_VALUE;
        int n = A.size();
        for(int i=0;i<n;i++){
            if(!map.contains(A.get(i)-1)){
                int temp = A.get(i);
                while(map.contains(temp)){
                    temp++;
                }
                max = Math.max(max, temp - A.get(i));
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
