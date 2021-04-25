import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public static void main(String[] args) {
        BrickWall o = new BrickWall();
//        System.out.println(o.leastBricks(Arrays.asList(Arrays.asList(1,2,2,1),Arrays.asList(3,1,2),
//                Arrays.asList(1,3,2),Arrays.asList(2,4),Arrays.asList(3,1,2),
//                Arrays.asList(1,3,1,1))));
//        System.out.println(o.leastBricks(Arrays.asList(Arrays.asList(2,2),Arrays.asList(3,1),
//                Arrays.asList(1,3))));
        System.out.println(o.leastBricks(Arrays.asList(Arrays.asList(1,1),Arrays.asList(2),
                Arrays.asList(1,1))));
    }
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> a : wall){
            int s = 0;
            for(int i=0;i<a.size()-1;i++){
                int ar = a.get(i);
                s = s + ar;
                int val = map.getOrDefault(s,0)+1;
                max = Math.max(max, val);
                map.put(s, val);
            }
        }
        // System.out.println(map.toString());
        return wall.size() - max;
    }
}
