public class PartitionToKSumEqual {

    private boolean isPresent(int sum, int totalSum, int idx, int[] nums, int k, boolean[] visited){
        if(k==0)
            return true;
        if(sum==totalSum){
            // Arrays.fill(visited, false);
            return isPresent(0, totalSum, 0, nums, k-1, visited);
        }
        if(idx>=nums.length)
            return false;
"".substring(2,2);
        for(int i=idx;i<nums.length;i++){

            if(sum+nums[i]<=totalSum && !visited[i]){

                visited[i] = true;
                if(isPresent(sum+nums[i], totalSum, i+1, nums, k, visited))
                    return true;
                visited[i] = false;
            }

        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        int n = nums.length;
        if(n==0)
            return false;
        for(int a : nums){
            sum+=a;
        }
        if(sum%k!=0){
            return false;
        } else {
            sum = sum/k;
            boolean[] visited = new boolean[n];
            return isPresent(0, sum, 0, nums, k, visited);
        }
    }
}
