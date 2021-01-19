import java.util.Arrays;

public class CutOffRanks {

    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        if(cutOffRank==0)
            return 0;
        Arrays.sort(scores);
        int i = num-1,c=1,k=1;
        for(i=num-2;i>=0;i--,k++){
            if(scores[i]!=scores[i+1]){
                c=num-i;
            }
            if(c>cutOffRank)
                break;
        }
        return k;
    }

    public static void main(String[] args) {
        CutOffRanks o = new CutOffRanks();

        System.out.println(o.cutOffRank(3,4, new int[]{100,50,50,25}));
    }
}
