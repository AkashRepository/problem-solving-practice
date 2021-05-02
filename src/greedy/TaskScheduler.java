package greedy;

import java.util.Comparator;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int maxc = 0;
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
            if (arr[c - 'A'] > max) {
                max = arr[c - 'A'];
                maxc = 1;
            } else if (arr[c - 'A'] == max) {
                maxc++;
            }
        }
        int empty = 0; //1 + 3*5 - 1*6 = 10
        empty = Math.max(empty, maxc + (n + 1) * (max - 1) - maxc * max);
        int nonMax = tasks.length - maxc * max;
        empty = Math.max(0, empty - nonMax);
        return empty + tasks.length;
    }
}
