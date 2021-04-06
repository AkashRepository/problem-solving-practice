package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseScheduleThree {


    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int farReached = 0;
        int count = 0;
        int n = courses.length;
        for(int i=0;i<n;i++){
            int[] course = courses[i];
            pq.offer(course);
            farReached = farReached + course[0];
            if(farReached > course[1]){
                int[] c = pq.poll();
                count++;
                farReached = farReached - c[0];
            }
        }
        return n-count;
    }
}
