package array;

public class BeautifulArrangement {

    int count = 0;

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void traverse(int i, int n, int[] arr){

        if(i==n){
            // System.out.println(Arrays.toString(arr));
            count++;
        }
        for(int j=i;j<n;j++){

            swap(arr, i, j);
            if((arr[i]%(i+1)==0 || (i+1)%arr[i]==0)){
                traverse(i+1, n, arr);
            }
            swap(arr, i, j);

        }

    }


    public int countArrangement(int n) {
        int[] arr = new int[n];
        count=0;
        for(int i=0;i<n;i++)
            arr[i] = i+1;

        traverse(0, n, arr);
        return count;
    }
}
