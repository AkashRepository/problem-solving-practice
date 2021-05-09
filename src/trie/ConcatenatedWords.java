package trie;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

    class Trie {
        boolean isWord; // for identifying the ending of the string
        int idx; // index of the string in words array
        char c;
        Trie[] nodes;

        public Trie(char c){
            this.c=c;
            this.nodes = new Trie[26];
        }

    }

    private void build(Trie t, String s, int idx){
        Trie n = t;

        for(char c: s.toCharArray()){
            if(n.nodes[c-'a'] == null){
                n.nodes[c-'a'] = new Trie(c);
            }
            n = n.nodes[c-'a'];
        }

        n.isWord = true; // update the last element as isWord and index of the String s
        n.idx = idx;
    }

    private boolean dfs(int idx, String s, Trie t, int oriIdx, Trie root){
        if(idx>=s.length())
            return false;
        char c = s.charAt(idx);
        Trie n = t.nodes[c-'a'];
        if(idx==s.length()-1){
            // we reached the end of string and last element isWord
            //and different string from the original s string,
            //thus it must be formed by concatenating other strings
            return n != null && n.isWord && oriIdx != n.idx;
        }
        if(n != null){
            if(n.isWord){ // if the element isWord then start checking next element from root
                if(dfs(idx+1, s, root, oriIdx, root))
                    return true;
            }
            if(dfs(idx+1, s, n, oriIdx, root))
                return true;
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> out = new ArrayList<>();

        Trie root = new Trie('/');
        root.idx = -1;

        int idx = 0;
        for(String s: words){
            build(root, s, idx++);
        }
        idx = 0;
        for(String s: words){
            if(dfs(0, s, root, idx++, root))
                out.add(s);
        }
        return out;
    }
}
