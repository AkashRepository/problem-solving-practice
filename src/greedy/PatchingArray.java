package greedy;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int count = 0;
        long max = 0;
        for(int i=0;i<nums.length;i++){

            if(max>=n)
                break;
            while(max+1<nums[i] && max<n){ //1<5, 3<5 7<5 12<10
                count++;//1 2
                max = max + (max + 1);
            }
            max=max+nums[i];

        }
        while(max<n){ //1<5, 3<5 7<5 12<10
            count++;//1 2
            max = max + (max + 1);
        }
        return count;
    }
}
