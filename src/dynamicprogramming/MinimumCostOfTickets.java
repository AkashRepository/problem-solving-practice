package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostOfTickets {

    public int minCostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] arr = new int[days[n-1]+1];
        // Arrays.fill(arr, -1);
        // for(int i=0;i<n;i++){
        //     arr[days[i]] = Integer.MAX_VALUE;
        // }
        // return combination(0, 0, arr, costs);

        for(int i=1,  j=0;i<arr.length;i++){
            if(i!=days[j]){
                arr[i] = arr[i-1];
                continue;
            }

            arr[i] = arr[i-1] + costs[0];
            if(i>=7)
                arr[i] = Math.min(arr[i], arr[i-7] + costs[1]);
            else
                arr[i] = Math.min(arr[i], costs[1]);
            if(i>=30)
                arr[i] = Math.min(arr[i], arr[i-30] + costs[2]);
            else
                arr[i] = Math.min(arr[i], costs[2]);
            j++;
//            System.out.println(Arrays.toString(arr));
        }
        return arr[days[n-1]];
    }

//Incorrect implementation
    private int combination(int i, int sum, int[] arr, int[] costs){
        if(i>=arr.length)
            return Integer.MAX_VALUE;

        while(i < arr.length-1 && arr[i]==-1)
            i++;



        if(i==arr.length-1)
            return sum +Math.min(Math.min(costs[0], costs[1]), costs[2]);

        // if(arr[i]!=-1 && arr[i]!=Integer.MAX_VALUE)
        //     return arr[i];

        int a = combination(i+1,sum+costs[0], arr, costs);
        a = Math.min(a, combination(i+7,sum+costs[1], arr, costs));
        a = Math.min(a, combination(i+15,sum+costs[2], arr, costs));

        arr[i] = Math.min(arr[i], a);
        // System.out.println(Arrays.toString(arr));
        return a;

    }

}
