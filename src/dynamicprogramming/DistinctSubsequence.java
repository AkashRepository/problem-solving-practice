package dynamicprogramming;

public class DistinctSubsequence {
    public int numDistinct(String s, String t) {
        //     r a b b b i t
        //  r  1
        //  a    1 1 1 1
    //      b      1 2 3
    //      b      1 2 3 2
    //      i            3
    //      t              3
        int n = s.length();
        int m = t.length();
        int[][] arr = new int[m][n];
        arr[0][0] = (s.charAt(0) == t.charAt(0)?1:0);
        for(int i=1;i<n;i++){
            arr[0][i] = arr[0][i-1] + (s.charAt(i) == t.charAt(0)?1:0);
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    arr[i][j] = 0;
                } else {
                    if( t.charAt(i) == s.charAt(j)){
                        arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
                    } else {
                        arr[i][j] = arr[i][j-1];
                    }
                }
            }
        }
        // for(int[] r: arr){
        //     System.out.println(Arrays.toString(r));
        // }
        return arr[m-1][n-1];
    }
}
