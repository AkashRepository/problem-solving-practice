package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KeyLocker {

    HashSet<Integer> hs = new HashSet<>();

    public static void main(String[] args) {
        KeyLocker o = new KeyLocker();
        System.out.println(o.openLock(new String[]{"0201","0101","0102","1212","2002"},
        "0202"));
    }
    
    public int openLock(String[] deadends, String target) {
        char[] t = target.toCharArray();
        Queue<char[]> q = new LinkedList<>();
        q.add("0000".toCharArray());
        int out = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            out++;
            while (size-- > 0) {
                char[] u = q.poll();
                if (Arrays.equals(u, t)) {
                    return out;
                }
                for (int i = 0; i < 4; i++) {
                    if (u[i] < '0' && u[i] > '8')
                        continue;
                    u[i] = (char) (u[i] + 1);
                    if (notContains(deadends, u)) {
                        System.out.println(Arrays.toString(u) + " " + i);
                        q.add(u.clone());
                    }
                    u[i] = (char) (u[i] - 1);
                }
            }
        }

        return -1;
    }

    private boolean notContains(String[] s, char[] c){
        int hash = Arrays.hashCode(c);
        if(hs.contains(hash)){
            return false;
        }
        for(String str: s){
            if(Arrays.equals(str.toCharArray(), c)){
                return false;
            }
        }
        hs.add(hash);
        return true;
    }
}
