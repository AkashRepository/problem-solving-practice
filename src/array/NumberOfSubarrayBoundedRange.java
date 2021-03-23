package array;

public class NumberOfSubarrayBoundedRange {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int n = A.length;
        int i=0,j=0,k=0, count=0;
        int out = 0;
        while(i<n){
            if(A[i]>=L && A[i]<=R){
                count = i-j+1;
                out = out + count;
            } else if(A[i] < L){
                out = out  + count;
            } else if(A[i]>R){
                count = 0;
                j = i+1;
            }
            i++;
        }

        return out;
    }
}
