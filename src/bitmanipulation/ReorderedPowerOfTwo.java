package bitmanipulation;

public class ReorderedPowerOfTwo {

//    Basic idea is to check for all the power of two numbers who have same number of digits present in N.
//            Example: Like N = 24, which have 2 digits, so only possible power of 2 number can be 16 and 64, as they have two digits.
//            N = 812, then power of 2 numbers possible are 128, 256 and 512.
//
//    So, we first find the most significant bit of the smallest and largest number possible by swapping. Example: N = 681, so smallest number possible is 168 and largest is 861.
//
//    Most significant/ right most set bit of smallest number will give us the smallest power of 2 number to start with and rightmost set bit of largest number will give us largest power of 2 number possible.
//    Example: N = 81, smallest number = 18 (10010) -> rightmost bit is at index 4.
//    So smallest power of 2 number is 2^4 = 16.
//    Similarly, 81 (1010001) -> rightmost bit is at index 6.
//    So largest power of 2 number is 2^6 = 64.
//
//    Now check for each power of 2 number to have same frequency count of digits that of original number (N).
//    Example N=812 will have same frequency count of digits 0-9 as that of 128.

    private int[] freqCount(int t){
        int[] arr = new int[10];
        while(t > 0){
            int idx = t%10;
            arr[idx]++;
            t = t/10;
        }
        return arr;
    }

    public boolean reorderedPowerOf2(int N) {

        int[] arr = freqCount(N);
        int min = 0;
        int factor = 1;
        int[] arrMin = arr.clone();
        for(int i=9;i>=0;i--){

            while(arrMin[i]>0){
                min = min + factor*i; // get the smallest number possible by swapping
                factor = factor*10;
                arrMin[i]--;
            }
        }
        int[] arrMax = arr.clone();
        int max = 0;
        factor = 1;
        for(int i=0;i<10;i++){

            while(arrMax[i]>0){
                max = max + factor*i;         // get the largest number possible by swapping
                factor = factor*10;
                arrMax[i]--;
            }
        }
        int minSetBit = (int)(Math.log(min) / Math.log(2)); // rightmost bit of minimum
        int maxSetBit = (int)(Math.log(max) / Math.log(2)); // leftmost bit of maximum
        int diff  = maxSetBit - minSetBit; // only have to diff + 1 times

        while(diff-->=0){
            boolean f = true;
            int powerTwo = 1<<minSetBit;
            int[] arr2 = freqCount(powerTwo); // check if freqCount of N and powerTwo are equal
            for(int i=0;i<10;i++){
                if(arr[i]!=arr2[i]){
                    f = false;
                }
            }
            if(f){
                return f;
            }
            minSetBit++;
        }
        return false;

    }
}
