public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] arr = new boolean[m+1][n+1];
        arr[0][0] = true;
        for(int i=1;i<=n;i++){
            arr[0][i] = arr[0][i-1] && p.charAt(i-1)=='*';
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    arr[i][j] = arr[i-1][j-1];
                } else if(p.charAt(j-1)=='*' && (arr[i-1][j-1] || arr[i-1][j] || arr[i][j-1])){
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
