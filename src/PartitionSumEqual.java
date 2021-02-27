import java.util.Collections;

public class PartitionSumEqual {


    public static void main(String[] args) {
        PartitionSumEqual o = new PartitionSumEqual();
        System.out.println(o.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
//        System.out.println(o.canPartition(new int[]{100,100,100,100,100,100,99,97}));
    }

    private boolean sumSubsequence(int i, int[] nums, int sum){
        if(i>=nums.length)
            return false;
        if(sum<0)
            return false;
        if(sum==0){
            return true;
        }
        return sumSubsequence(i+1,nums,sum-nums[i]) ||
                sumSubsequence(i+1,nums,sum);
    }


    public boolean canPartition(int[] nums) {

        int sum = 0;
        int n = nums.length;
        for(int a : nums){
            sum+=a;
        }
        if(sum%2==1){
            return false;
        } else {
            sum = sum/2;
            boolean[][] arr = new boolean[sum+1][n+1];

            for(int i=0;i<=n;i++)
                arr[0][i] = true;

            for(int i=1;i<=sum;i++){
                for(int j=1;j<=n;j++){
                    if(i>=nums[j-1])
                        arr[i][j] = arr[i][j-1] || arr[i-nums[j-1]][j-1];
                    else
                        arr[i][j] = arr[i][j-1];
                }
            }
            return arr[sum][n];

        }
    }
}
