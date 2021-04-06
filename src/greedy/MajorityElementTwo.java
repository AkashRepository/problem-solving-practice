package greedy;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
    // based on voting algorithm

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> out = new ArrayList<>();
        int prev = -1;
        int pp = -1;
        int pc = 0;
        int ppc = 0;
        int n = nums.length;
        for(int a: nums){

            if(a==prev){
                pc++;
            } else if(a==pp){
                ppc++;
            } else if(pc==0){
                prev=a;
                pc=1;
            } else if (ppc==0){
                pp = a;
                ppc=1;
            } else {
                pc--;
                ppc--;
            }
        }
        pc=0;
        ppc=0;
        for(int a: nums){
            if(a==prev){
                pc++;
            } else if(a==pp){
                ppc++;
            }
        }
        if(pc>n/3){
            out.add(prev);
        }
        if(ppc>n/3){
            out.add(pp);
        }

        return out;
    }
}
