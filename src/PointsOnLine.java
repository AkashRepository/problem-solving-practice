import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointsOnLine {

    public static void main(String[] args) {
        PointsOnLine o =new PointsOnLine();
        o.maxPoints(new int[][]{{2,3},{3,3},{-5,3}});
    }
    public int maxPoints(int[][] points) {
        int n = points.length;
        int out = 0;
        if(n==1)
            return n;
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // if(i==j)
                //     continue;
                Double m = null;
                if(points[i][1]==points[j][1]){
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
}
