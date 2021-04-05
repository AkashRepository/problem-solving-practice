package dynamicprogramming;


import jdk.internal.util.xml.impl.Pair;

import java.math.BigInteger;
import java.util.*;

public class MaximumScoreAfterNOperations {

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    static class Node {
        Integer a;
        Integer b;

        public Node(Integer a,Integer b){this.a=a;this.b=b;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(a, node.a) && Objects.equals(b, node.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }


    private int dfs(int idx, int[] nums, boolean[] vi, int n, Map<Node, Integer> map){
        int max = 0;
        if(idx>n/2)
            return max;

        Node p = new Node(Arrays.hashCode(vi), idx);
        if(map.get(p)!=null){
            return map.get(p);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!vi[i] && !vi[j]){
                    vi[i]=true;
                    vi[j]=true;
                    int value = idx*gcd(nums[i],nums[j]) + dfs(idx+1,nums, vi, n,map);
                    max = Math.max(max, value);
                    vi[i]=false;
                    vi[j]=false;
                }
            }
        }
        map.put(p, max);
        return max;
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        int out = 0;
        Map<Node, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        return dfs(1,nums, visited, n, map);
    }
}
