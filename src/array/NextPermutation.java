package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = 0;
        int n = nums.length;

        for(i=n-1;i>0;i--){
            if(nums[i-1]<nums[i])
                break;
        }
        if(i!=0){
            int val = nums[i-1];
            int min = nums[i];
            int mi = i;
            for(int j = i+1;j<n;j++){
                if(nums[j]>val){
                    if(min >= nums[j]){
                        min = nums[j];
                        mi = j;
                    }
                }
            }
            nums[i-1] = min;
            nums[mi] = val;
        }
        reverse(nums, i, n-1);
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}