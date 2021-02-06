public class KthLargestElement {

    private void swap(int[] n, int i, int j){
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<k;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j+1,j);
                }
            }
        }
        return nums[n-k];
    }


    public int findKthLargest(int[] nums, int k){
        int n = nums.length;
        if(k<0 || k >n)
            return -1;
        return dnc(nums, 0, n-1, n-k);


    }

    private int dnc(int[] n, int s, int e, int k){

        int pi = s;
        for(int i=s;i<=e;i++){
            if(n[i]<=n[e]){
                swap(n, i, pi);
                pi++;
            }
        }
        pi--;
        if(pi==k){
            return n[k];
        } else if(pi < k){
            return dnc(n, pi+1, e, k);
        } else {
            return dnc(n, s, pi-1, k);
        }
    }

}
