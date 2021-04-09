package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfThree {

    public static void main(String[] args) {
        ProductOfThree o = new ProductOfThree();
        System.out.println(o.maxp3(Arrays.asList(-65, 41, 15, -11, 69, 23, -63, -4, 49, -99, -61, 17, -61 )));
    }

    public int maxp3(List<Integer> A) {

        Integer lowest = null;
        Integer secondLowest = null;
        Integer highest = null;
        Integer secondHighest = null;
        Integer thirdHighest = null;

        for(Integer a: A){
            if(highest==null || highest < a){
                thirdHighest = secondHighest;
                secondHighest = highest;
                highest = a;
            } else if(secondHighest==null || secondHighest < a){
                thirdHighest = secondHighest;
                secondHighest = a;
            } else if (thirdHighest==null || thirdHighest < a){
                thirdHighest = a;
            }
            if(a<0 && (lowest==null || a < lowest)) {
                secondLowest = lowest;
                lowest = a;
            } else if (a<0 && (secondLowest == null || a < secondLowest)){
                secondLowest = a;
            }
        }
        if(lowest==null || secondLowest==null){
            return highest * secondHighest * thirdHighest;
        } else {
            return Math.max(highest * secondHighest * thirdHighest, highest * lowest * secondLowest);
        }
    }
}
