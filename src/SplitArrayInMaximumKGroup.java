public class SplitArrayInMaximumKGroup {


    public static void main(String[] args) {
        SplitArrayInMaximumKGroup o = new SplitArrayInMaximumKGroup();
//        System.out.println(o.splitArray(new int[]{1,4,4},3));
        int[] ar = new int[]{0,1,2,3,4,6,7,8};
        int out = 0;
        for(int i=0;i<ar.length;i++){
            out = out ^ ar[i] ^ i;
        }
        out = out ^ ar.length;
        System.out.println(out);
    }


    private boolean canWeDivide(int mid, int[] nums, int m){
        int sum = 0, arrCount = 0;
        for(int i=0;i<nums.length;i++){
            int temp = sum + nums[i];
            if(temp > mid){
                sum = nums[i];
                arrCount++;
                if(arrCount > m)
                    return false;
            } else {
                sum = temp;
            }
        }
        if(sum<=mid)
            arrCount++;
        return arrCount<=m;
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int i=0;

        int s = nums[0];
        int mi = nums[0];
        for(i=1;i<n;i++){
            s=s+nums[i];
            mi = Math.max(mi, nums[i]);
        }
        int min = Math.max(mi, (int)Math.ceil(s/m));
        int max = s;

        i=min;
        int j=max;
        while(i<j){
            int mid = (i+j)/2;
            if(canWeDivide(mid, nums, m)){
                j = mid;
            } else {
                i = mid + 1;
            }
            // System.out.println(i +" : "+j);
        }
        return j;


    }

}
