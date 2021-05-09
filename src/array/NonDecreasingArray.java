package array;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean f = false;
        if(n<=2)
            return true;
        for(int i=0;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                //increasing
            } else if (!f && i>=1 && nums[i+1]<nums[i-1] ){
                f = true;
                nums[i+1] = nums[i];
            } else if(!f && i>=1 && nums[i+1]>=nums[i-1]){
                f = true;
                nums[i]=nums[i+1];
            } else {
                if(f)
                    return false;
                f = true;
            }
        }
        return true;
    }
}
