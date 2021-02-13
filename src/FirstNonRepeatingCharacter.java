import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        FirstNonRepeatingCharacter o = new FirstNonRepeatingCharacter();

        System.out.println(o.solve("ptp"));
    }

    public String solve(String A) {
        int[] arr = new int[26];
        Queue<Character> q = new LinkedList<>();
//        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> arr[a-'a']-arr[b-'a']);
        StringBuilder sb = new StringBuilder();
        for(char c: A.toCharArray()){
            arr[c-'a']++;
            if(arr[c-'a']==1)
                q.add(c);
            else if(arr[c-'a']==2)
                q.remove(c);
            sb.append(q.isEmpty()?'#':q.peek());
        }
        return sb.toString();
    }
}
