package string;

public class StringBreak {

    public static void main(String[] args) {
        StringBreak o =new StringBreak();
        System.out.println(o.checkIfCanBreak("janrudfu",
                "xjdxkxwq"));
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(char c : s1.toCharArray()){
            a[c-'a']++;
        }
        for(char c : s2.toCharArray()){
            b[c-'a']++;
        }
        int i=0,j=0;
        boolean f = false;
        for(int k=25;k>=0;k--){
            if(a[k]!=0)
                i=i+a[k];
            if(b[k]!=0)
                j=j+b[k];
            if(i>j){
                f= true;
                break;
            }
        }
        if(f){
            i=0;j=0;
            for(int k=25;k>=0;k--){
                if(a[k]!=0)
                    i=i+a[k];
                if(b[k]!=0)
                    j=j+b[k];
                if(i<j){
                    return false;
                }
            }
        }
        return true;
    }
}
