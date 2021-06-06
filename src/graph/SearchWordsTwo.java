package graph;

import java.util.ArrayList;
import java.util.List;

public class SearchWordsTwo {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> out = new ArrayList<>();


        int r = board.length;
        int c = board[0].length;


        for (String w : words) {

            List<int[]> startingPoint = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == w.charAt(0)) {
                        startingPoint.add(new int[]{i, j});
                    }
                }
            }

            for (int[] p : startingPoint) {
                boolean[] found = new boolean[1];
                dfs(p[0],p[1],r, c, board, w,0,found);
                if(found[0]){
                    out.add(w);
                    break;
                }
            }
        }

        return out;
    }

    public void dfs(int i, int j, int r, int c, char[][] board, String str, int idx, boolean[] found) {
        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] != str.charAt(idx) || board[i][j] == '#' || found[0]) {
            return;
        }
        if(board[i][j]==str.charAt(idx)){
            if(idx == str.length() - 1) {
                found[0] = true;
                return;
            }
            idx = idx + 1;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(i+1, j, r, c, board, str, idx, found);
        dfs(i, j-1, r, c, board, str, idx, found);
        dfs(i-1, j, r, c, board, str, idx, found);
        dfs(i, j+1, r, c, board, str, idx, found);
        board[i][j] = temp;
        return;

    }

    public static void main(String[] args) {
        SearchWordsTwo o = new SearchWordsTwo();
        System.out.println(o.findWords(new char[][] {{'a'}}, new String[]{"a"}));
//        System.out.println(o.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}
//                , new String[]{"oath", "pea", "eat", "rain"}));
    }

}
