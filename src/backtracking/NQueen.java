package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {

    ArrayList<ArrayList<String>> out = new ArrayList<>(); // result

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        char[][] ch = new char[n][n];


        for(int i=0;i<n;i++){
            Arrays.fill(ch[i],'.');
        }
        nQueen(0, n, ch); //0th row or first row
        return out;
    }

    private void nQueen(int row, int n, char[][] arr){
        if(row==n){
            ArrayList<String> arr2 = new ArrayList<>();
            for(char[] c : arr){
                arr2.add(new String(c));
            }
            out.add(arr2);
            return;
        }

        for(int col=0;col<n;col++){

            if(isSafe(row, col, n, arr)){
                arr[row][col] = 'Q';
                nQueen(row+1, n, arr);
                arr[row][col] = '.';
            }
        }

    }

    /*
            \   |   /
             \  |  /
              \ | /
               \|/
            [row,col]    have to check in these directions, previously for any rows we have not added a Queen
    */

    private boolean isSafe(int row, int col, int n, char[][] arr ){

        for(int i=0;i<=row;i++){ // check for within same col for all thr previous rows
            if(arr[i][col]=='Q')
                return false;
        }
        for(int i=row, j=col;i>=0 && j>=0;i--,j--){ // check for left side diagonal
            if(arr[i][j]=='Q')
                return false;
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){ // check for right side diagonal
            if(arr[i][j]=='Q')
                return false;
        }

        return true;
    }
}
