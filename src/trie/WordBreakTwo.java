package trie;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTwo {

    static class Trie {
        Trie[] arr;
        boolean isWord;

        Trie(){
            this.arr = new Trie[26];
            isWord = false;
        }
    }

    List<String> out = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> words) {
        Trie t = new Trie();
        for(String word : words)
            insert(t, word);

        search(t, s);
        return out;
    }

    private void insert(Trie t, String word){
        Trie node = t;
        for(int i=0;i<word.length();i++){
            if(node.arr[word.charAt(i)-'a']==null){
                node.arr[word.charAt(i)-'a'] = new Trie();
            }
            node = node.arr[word.charAt(i)-'a'];
        }
        node.isWord=true;
    }

    private void search(Trie t, String s){
        Trie node = t;
        List<List<Integer>> idx = new ArrayList<>(); // capture all the index where isWord is true

        int n = s.length();
        for(int i=0;i<=n;i++){
            idx.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            node = t;
            if(i==0 || (idx.get(i).size()>0)){
                for(int j=i;j<n;j++){
                    if(node!=null){
                        node = node.arr[s.charAt(j)-'a'];
                        if(node!=null && node.isWord){
                            idx.get(j+1).add(i); //s.substring(i,j) is a word
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        traverse(idx, n,s, ""); //backtrack from last index and recursively add the substrings

    }

    private void traverse(List<List<Integer>> idx, int i, String s, String p){
        if(i==0){ //base case when we reach the 0th index add the string to output
            out.add(p.trim());
            return;
        }

        for(Integer id : idx.get(i)){
            traverse(idx, id,s, s.substring(id,i) + " " +p);
        }

    }
}
