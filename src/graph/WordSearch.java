package graph;

import java.util.Arrays;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch o = new WordSearch();
//        System.out.println(o.exist(Arrays.asList("FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"), "BCDCB"));
        System.out.println(o.exist(Arrays.asList("BGGAGBGE", "EFFAGBEG", "FGGCBBFF", "BEEBDEDC", "FACABDCD", "ECGEFFED", "GDBEGACG", "GCECFBBD"), "CABBFFEAC"));
    }

    public int exist(List<String> A, String B) {
        int m = A.size();
        int n = A.get(0).length();
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = A.get(i).charAt(j);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==B.charAt(0)){
                    if(dfs(arr, i, j, B, 0, m, n ))
                        return 1;
                }
            }
        }
        return 0;
    }

    private boolean dfs(char[][] arr, int i, int j,String b, int idx, int m , int n) {

        if (i < 0 || j < 0 || i >= m || j >= n || idx > b.length())
            return false;
        char temp = arr[i][j];

        boolean isEqual = temp == b.charAt(idx);

        if (idx == b.length() - 1 && isEqual) {
            return true;
        }
        if (!isEqual)
            return false;

        idx++;
        // arr[i][j]='-';

        boolean flag = dfs(arr, i + 1, j, b, idx, m, n) ||
                dfs(arr, i - 1, j, b, idx, m, n) ||
                dfs(arr, i, j + 1, b, idx, m, n) ||
                dfs(arr, i, j - 1, b, idx, m, n);
        // arr[i][j]=temp;
        return flag;
    }
}
