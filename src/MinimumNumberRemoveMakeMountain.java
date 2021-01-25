import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumNumberRemoveMakeMountain {

//    public int minimumMountainRemovals(int[] arr) {
//        int n = arr.length;
//        int[] in = new int[n];
//        int[] de = new int[n];
//        Arrays.fill(in,1);
//        Arrays.fill(de,1);
//
//        for(int i=1;i<n;i++){
//            for(int j=0;j<i;j++){
//                if(arr[i] > arr[j] && in[i] < in[j]+1){
//                    in[i] = in[j]+1;
//                }
//            }
//        }
//        for(int i=n-2;i>=0;i--){
//            for(int j=n-1;j>i;j--){
//                if(arr[i] > arr[j] && de[i] < de[j]+1){
//                    de[i] = de[j]+1;
//                }
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for(int i=1;i<n-1;i++){
//            if(in[i]>1 && de[i]>1)
//                min = Math.min(min, n - in[i]-de[i]+1);
//        }
//        List<Integer> l = new ArrayList<>();
//        l.add(3);l.add(7);l.add(2);l.add(10);l.add(6);
//        int i = Collections.binarySearch(l, 5);
//        System.out.println(i);
//        return min;
//    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] leftLIS = new int[n];
        int[] rightLIS = new int[n];

        List<Integer> lis = new ArrayList();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                int insert = -idx-1;

                if (insert < lis.size()) {
                    lis.set(insert, num);
                } else {
                    lis.add(num);
                }
            }

            leftLIS[i] = lis.size();
        }

        lis.clear();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                int insert = -idx-1;

                if (insert < lis.size()) {
                    lis.set(insert, num);
                } else {
                    lis.add(num);
                }
            }

            rightLIS[i] = lis.size();
        }

        // System.out.println(Arrays.toString(leftLIS));
        // System.out.println(Arrays.toString(rightLIS));

        int ans = Integer.MAX_VALUE;

        int start = 1;
        int end = n-2;

        while (start <= n-2 && nums[start-1] > nums[start]) {
            start++;
        }
        while (end >= 0 && nums[end+1] > nums[end]) {
            end--;
        }

        for (int i = start; i <= end; i++) {
            if (leftLIS[i] < 2 || rightLIS[i] < 2) {
                continue;
            }
            ans = Math.min(ans, n - leftLIS[i] - rightLIS[i] + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberRemoveMakeMountain o = new MinimumNumberRemoveMakeMountain();
        System.out.println(o.minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
    }
}
