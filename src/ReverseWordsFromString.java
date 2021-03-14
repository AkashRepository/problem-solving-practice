public class ReverseWordsFromString {

    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i=0,j=0;
        int n = s.length();
        while(j<n && i<n){
            // while(i<n && c[i]==' '){
            //     i++;
            // }facto
            j=i;

            while(j<n && c[j]==' '){
                j++;
            }
            while(j<n && c[j]!=' '){
                j++;
            }
            // System.out.println(Arrays.toString(c));
            c = reverse(i, j-1, n, c);
            while(i<n && c[i]!=' '){
                i++;
            }
            i = i+1;
        }
        i=0;
        while(i<n && i==' '){
            i++;
        }
        j=n-1;
        while(j>=0 && j==' '){
            j--;
        }

        c = reverse(i,j,n,c);
        return new String(c).trim();
    }

    private char[] reverse(int i, int j, int n, char[] c){
        if(i>=n || j>=n)
            return c;
        while(i<j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        // System.out.println(Arrays.toString(c));
        return c;
    }
}
