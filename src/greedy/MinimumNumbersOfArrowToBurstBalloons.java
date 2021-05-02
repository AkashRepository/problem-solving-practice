package greedy;

import java.util.Arrays;

public class MinimumNumbersOfArrowToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==0)
            return 0;
        Arrays.sort(points, (a, b) -> {
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int prev = points[0][1];
        int out = 1;
        for(int i=1;i<n;i++){
            if(points[i][0]<=prev){
                prev = Math.min(points[i][1], prev);
            } else {
                out++;
                prev = points[i][1];
            }
        }
        return out;
    }
}
