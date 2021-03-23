package dynamicprogramming;

public class LargestPlusSign {

    //Could reduce size to arr[N][N] by checking for in memory
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][] arr = new int[N][N][4];
        int max = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j][0]=1;
                arr[i][j][1]=1;
                arr[i][j][2]=1;
                arr[i][j][3]=1;
            }
        }

        for(int i=0;i<mines.length;i++){
            arr[mines[i][0]][mines[i][1]][0] = 0;
            arr[mines[i][0]][mines[i][1]][1] = 0;
            arr[mines[i][0]][mines[i][1]][2] = 0;
            arr[mines[i][0]][mines[i][1]][3] = 0;
        }

        //[0]=left, [1]=right, [2]=up, [3]=down
        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                if(arr[i][j][0]!=0){
                    arr[i][j][0] = arr[i][j-1][0]+1;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=N-2;j>=0;j--){
                if(arr[i][j][1]!=0){
                    arr[i][j][1] = arr[i][j+1][1]+1;
                }
            }
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j][2]!=0){
                    arr[i][j][2] = arr[i-1][j][2]+1;
                }
            }
        }

        for(int i=N-2;i>=0;i--){
            for(int j=0;j<N;j++){
                if(arr[i][j][3]!=0){
                    arr[i][j][3] = arr[i+1][j][3]+1;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                max = Math.max(max, Math.min(Math.min(arr[i][j][0],arr[i][j][1]), Math.min(arr[i][j][2],arr[i][j][3])));
            }
        }
        return max;


    }
}
