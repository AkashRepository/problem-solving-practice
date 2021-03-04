import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,12);
        map.put(3,7);
        map.put(5,9);

        boolean[][] arr = new boolean[m+1][n+1];
        arr[0][0] = true;
        for(int i=2;i<=n;i=i+2){
            if(p.charAt(i-1)=='*'){
                arr[0][i] = arr[0][i-2]; //s = *a*b*c , p = ""
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    arr[i][j] = arr[i-1][j-1];
                } else if(j>=2 && p.charAt(j-1)=='*' && arr[i][j-2] || ((p.charAt(j-2)==s.charAt(i-1)
                || p.charAt(j-2)=='.') && arr[i-1][j])){
                    arr[i][j] = true;
                }
            }
        }

        // for(boolean[] a: arr){
        //     System.out.println(Arrays.toString(a));
        // }

        return arr[m][n];
    }
}
