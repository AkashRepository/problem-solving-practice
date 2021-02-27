import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryAfterDeletion {

    public static void main(String[] args) {
        LongestWordInDictionaryAfterDeletion o = new LongestWordInDictionaryAfterDeletion();
//        System.out.println(o.findLongestWord("bab",
//                Arrays.asList("ba","ab","a","b")));
        System.out.println(o.findLongestWord("aewfafwafjlwajflwajflwafj",
                Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));
    }

    public String findLongestWord(String s, List<String> d) {
        String maxStr = "";
        int max = 0;
        int n = s.length();
        for (String str : d) {
            int m = str.length();
            int i = m-1;
            int j= n;
            while(--j>=0 && i>=0){
                if(s.charAt(j)==str.charAt(i)){
                    i--;
                }
            }
            if(i<0 && max <= m){
                if(max==m && str.compareTo(maxStr)<0){
                    maxStr = str;
                } else if(max!=m){
                    maxStr = str;
                    max = m;
                }
            }
        }
        return maxStr;
    }
}
