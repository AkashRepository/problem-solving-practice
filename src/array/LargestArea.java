package array;

import java.util.Arrays;

public class LargestArea {

    public static void main(String[] args) {
        LargestArea o = new LargestArea();
        System.out.println(o.maxArea(1000000000,1000000000,new int[]{2,1}, new int[]{2,1}));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hs = horizontalCuts.length;
        int vs = verticalCuts.length;
        long hl = h;
        long wl = w;
        long maxV = 0;
        long maxH = 0;
        long prev = 0;
        for(int i=0;i<hs;i++){
            maxH = Math.max(maxH, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }

        maxH = Math.max(maxH, hl - prev);
        prev = 0;
        for(int i=0;i<vs;i++){
            maxV = Math.max(maxV, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        maxV = Math.max(maxV, wl - prev);
        return (int) ((maxV*maxH)%1_000_000_007);
    }
}
