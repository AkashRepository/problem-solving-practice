import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class TransactionLog {

    public String[] processLogFile(String[] logs, int threshold) {
        HashMap<String, Integer> h = new HashMap<>();
        TreeSet<String> hs = new TreeSet<>();
        for (String s : logs) {
            String[] s1 = s.split(" ");
            h.put(s1[0], h.getOrDefault(s1[0], 0) + 1);
            if (!s1[0].equals(s1[1]))
                h.put(s1[1], h.getOrDefault(s1[1], 0) + 1);
            if (h.get(s1[0]) >= threshold) {
                hs.add(s1[0]);
            }
            if (h.get(s1[1]) >= threshold) {
                hs.add(s1[1]);
            }
        }
        String[] s = new String[hs.size()];
        return hs.toArray(s);
    }

    public static void main(String[] args) {
        TransactionLog o = new TransactionLog();
        System.out.println(Arrays.toString(o.processLogFile(new String[]{"88 99 200", "88 99 300", "99 32 100", "12 12 15"}, 2)));
    }
}
