package string;

import java.util.LinkedList;
import java.util.Queue;

public class CountAndSay {

    public String countAndSay(int A) {
        if(A==0)
            return "";
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add('1');
        int j = 0;
        for(int i=2;i<=A;i++){
            Queue<Character> q2 = new LinkedList<>();
            while(!q.isEmpty()){
                int count = 1;
                Character prev = q.poll();
                while(!q.isEmpty() && prev==q.peek()){
                    count++;
                    q.remove();
                }
                q2.add((char)(count + '0'));
                q2.add(prev);
            }
            q = q2;
        }
        while(!q.isEmpty()){
            sb.append(q.remove());
        }
        return sb.toString();
    }
}
