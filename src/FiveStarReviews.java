import java.util.PriorityQueue;

public class FiveStarReviews {

    public int max(int[][] p){
        int o=0,i=0;
        double max=-1.0,t=0.0;
        for(int[] a:p){
            double d = (a[0]*1.0+1)/(a[1]+1) - (a[0]*1.0/a[1]);
            if(d>max){
                max = d;
                o = i;
            }
            i++;
        }
        return o;
    }

    public int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
       double t=threshold(productRatings);
       int i=0,j=0,c=0;
        while(t<ratingsThreshold){
            int idx = max(productRatings);
            productRatings[idx][0]++;
            productRatings[idx][1]++;
            t = threshold(productRatings);
            c++;
        }
        return c;
    }

    private double threshold(int[][] p) {
        double max=-1.0,t=0.0;
        for(int[] a:p){
            t += (a[0]*1.0)/(a[1]) ;
        }
        t = t*100/p.length;
        return t;
    }

    public static void main(String[] args) {
        FiveStarReviews o = new FiveStarReviews();
        System.out.println(o.fiveStarReviews(new int[][]{{4,4}, {1,2}, {3, 6}},77));
    }

}
