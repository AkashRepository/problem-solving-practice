package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class MaximumPointsOnALine {

    public int maxPoints(int[][] points) {
        int n = points.length;
        int out = 0;
        if(n==1)
            return n;
        Map<Double, Integer> map = new HashMap<>(); // count pairs of points having same slops
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                Double m = null; // null values as key is for vertical lines having slop = 90degree
                if(points[i][1]==points[j][1]){ // straight horizontal line
                    m = 0.0;
                } else
                if(points[i][0]!=points[j][0]){
                    m = ((points[i][1]-points[j][1])*1.0)/(points[i][0]-points[j][0]);
                }


                int val = map.getOrDefault(m,1);
                map.put(m, val+1);
            }
            for(Integer val : map.values()){
                out = Math.max(out, val);
            }
            map = new HashMap<>();
        }
        return out;


    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
