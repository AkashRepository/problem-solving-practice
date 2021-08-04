package array;

public class LargestMagicSquare {

    public static void main(String[] args) {
        LargestMagicSquare o = new LargestMagicSquare();
        System.out.println(o.largestMagicSquare(new int[][]{{5,1,3,1},{9,3,3,1},{1,3,3,8}}));
    }

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] arr = new int[m][n][2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j][0] = grid[i][j];
                arr[i][j][1] = grid[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j][0] += arr[i][j-1][0];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                arr[j][i][1] += arr[j-1][i][1];
            }
        }
        int k = Math.min(m,n);
        while(k>0){
            for(int i=0;i+k<m;i++){
                for(int j=k-1;j<n;j++){
                    int value = arr[i][j][0];
                    if((j-k)>=0){
                        value = value - arr[i][j-k][0];
                    }

                    int l = i+1;
                    boolean flag = true;
                    while(l<k){
                        int prev = value;
                        value = arr[l][j][0];
                        if((j-k)>=0){
                            value = value - arr[l][j-k][0];
                        }
                        if(value != prev){
                            flag = false;
                            break;
                        }
                        l++;
                    }
                    if(flag){
                        value = arr[i+k-1][j][1];
                        if((i-1)>=0){
                            value = value - arr[i-1][j][1];
                        }
                        l = j-1;
                        flag = true;
                        while(l>(j-k)){
                            int prev = value;
                            value = arr[i+k-1][l][1];
                            if((i-1)>=0){
                                value = value - arr[i-1][l][1];
                            }
                            if(value != prev){
                                flag = false;
                                break;
                            }
                            l--;
                        }
                        if(flag){
                            int sum = 0;
                            for(int x =i;x<i+k;x++){
                                sum = sum + grid[x][x];
                            }
                            if(sum!=value){
                                flag = false;
                            }
                            if(flag){
                                sum = 0;
                                for(int x =j;x>=0;x--){
                                    sum = sum + grid[x][x];
                                }
                                if(sum==value){
                                    return k;
                                } else {
                                    flag = false;
                                }
                            }
                        }
                    }
                }
            }
            k--;
        }
        return 0;
    }
}
