package trie;

import java.util.Arrays;
import java.util.LinkedList;

public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        NumberOfMatchingSubsequences o = new NumberOfMatchingSubsequences();
        System.out.println(o.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }

    public int numMatchingSubseq(String s, String[] words) {
        int out = 0;
        int n = s.length();


        LinkedList<StringBuilder>[] arr = new LinkedList[26];

        for(int i=0;i<26;i++)
            arr[i] = new LinkedList<>();

        for(String word: words){
            arr[word.charAt(0)-'a'].add(new StringBuilder(word));
        }


        for(char c: s.toCharArray()){
            int size = arr[c-'a'].size();
            while(size-->0){

                System.out.println(c);
                StringBuilder sb = arr[c-'a'].removeFirst();
                sb.deleteCharAt(0);
                if(sb.length()==0){
                    out++;
                } else {
                    arr[sb.charAt(0)-'a'].addLast(sb);
                }
            }
        }
        return out;
    }
}
