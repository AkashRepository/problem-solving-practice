package backtracking;

public class PalindromePartitionFour {

    public static void main(String[] args) {
        PalindromePartitionFour o = new PalindromePartitionFour();
        System.out.println(o.checkPartitioning("abcbdd"));
    }
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] arr = new boolean[n][n];

        for(int i=0;i<n;i++){
            arr[i][i] = true;
            if(i+1<n && s.charAt(i)==s.charAt(i+1)){
                arr[i][i+1] = true;
            }
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<n-i;j++){
                int k = j + i;
                if(s.charAt(j)==s.charAt(k) && arr[j+1][k-1]){
                    arr[j][k] = true;
                }
            }
        }

        // for(boolean b[] : arr)
        //     System.out.println(Arrays.toString(b));

        return backtrack(0,arr, n, 2);
        // return arr[n-1][2];
    }

    private boolean backtrack(int i, boolean[][] arr, int n, int left) {
        if(i>=n)
            return false;
        if(left==0){
            return arr[i][n-1];
        }
        boolean flag = false;
        for(int ii=i;ii<n;ii++){
            if(arr[i][ii]){
                flag = flag || backtrack(ii+1, arr, n, left-1);
            }
        }
        return flag;
    }
}
