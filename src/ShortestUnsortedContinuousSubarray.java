public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0], maxIdx=0, min = nums[nums.length-1], minIdx =nums.length-1;
        int start  = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){

            if(nums[i]<max){
                start = Math.min(start, maxIdx);
                last = i;
            }

            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
        }
        for(int i=nums.length-1;i>=0;i--){

            if(nums[i]>min){
                start = Math.min(start, i);
                last = Math.max(last, minIdx);
            }

            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }

        if(start == Integer.MAX_VALUE || last == Integer.MIN_VALUE)
            return 0;
        return last - start + 1;
    }
}
