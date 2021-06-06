package dynamicprogramming;

public class EditDistance {

    public int minDistance(String A, String B) {
        int a = A.length();
        int b = B.length();
        int n = 0;
        int[][] arr = new int[a+1][b+1];

        for(int i=0;i<=a;i++) {
            for(int j=0;j<=b;j++) {
                if(i==0 && j==0){
                    arr[0][0] = 0;
                } else if(i==0){
                    arr[0][j] = j;
                } else if(j==0){
                    arr[i][0] = i;
                } else if(A.charAt(i-1)==B.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1];
                } else {
                    arr[i][j] = 1 + Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]));
                }
            }
        }
        return arr[a][b];
    }
}
