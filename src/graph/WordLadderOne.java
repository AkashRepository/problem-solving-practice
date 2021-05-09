package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderOne {

    private boolean isEqual(String u, String b) {
        boolean f = false;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != b.charAt(i)) {
                if (f)
                    return false;
                f = true;
            }
        }
        return f;
    }

    public int solve(String A, String B, ArrayList<String> C) {

        Queue<String> q = new LinkedList<>();
        int n = C.size();
        q.add(A);
        boolean[] vi = new boolean[n];
        int out = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String u = q.poll();

                if (u.equals(B) || isEqual(u, B)) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if (!vi[i] && isEqual(u, C.get(i))) {
                        q.add(C.get(i));
                        vi[i] = true;
                    }
                }
            }
            out++;
        }
        return out+1;
    }

    public static void main(String[] args) {
        WordLadderOne o = new WordLadderOne();
        System.out.println(o.solve("ymain",
                "oecij",
        new ArrayList<>(Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"))));
    }
}
