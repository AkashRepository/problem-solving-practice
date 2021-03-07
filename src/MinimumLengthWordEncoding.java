import java.util.Arrays;

public class MinimumLengthWordEncoding {
    public static void main(String[] args) {
        MinimumLengthWordEncoding o = new MinimumLengthWordEncoding();
        System.out.println(o.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(o.minimumLengthEncoding(new String[]{"time", "me", "m"}));
        System.out.println(o.minimumLengthEncoding(new String[]{"t"}));
        System.out.println(o.minimumLengthEncoding(new String[]{"akash","kas","h","time", "me"}));
        System.out.println(o.minimumLengthEncoding(new String[]{"akash","kas","h", "time"}));
    }

    private static boolean  endsWith(String word, String end){
        if(end.length() > word.length())
            return false;
        int i = word.length()-1;
        for(int j=end.length()-1; j>=0;j--){
            if(word.charAt(i--) != end.charAt(j)){
                return false;
            }
        }
        return true;
    }

    static class Trie {
        char c;
        Trie[] tries = new Trie[26];

        public Trie(char c){
            this.c=c;
        }

    }

    public boolean insert(Trie trie, String word){
        Trie current = trie;
        int n = word.length();
        boolean flag = false;
        for(int i=n-1;i>=0;i--){
            if(current.tries[word.charAt(i)-'a']==null){
                current.tries[word.charAt(i)-'a'] = new Trie(word.charAt(i));
                flag = true; // did not completely matched means needs to be added to the total sum
            }
            current = current.tries[word.charAt(i)-'a'];
        }
        return flag; // if false, means all nodes were present no need to add

    }



    public int minimumLengthEncoding(String[] words) {
        int out = 0;
        Arrays.sort(words, (a, b) -> b.length()-a.length());
        Trie trie = new Trie('/');
        for(String word : words){
            if(insert(trie, word)){
                out = out + word.length() + 1;
            }
        }

        return out;
    }


}
