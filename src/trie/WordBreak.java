package trie;

import java.util.*;

public class WordBreak {

    boolean f = false;

    static class Trie {
        boolean isWord;
        Trie[] arr;

        public Trie() {
            arr = new Trie[26];
        }

    }

    private void insert(Trie t, String str) {
        Trie temp = t, n = null;
        for (char c : str.toCharArray()) {
            if (temp.arr[c - 'a'] == null)
                temp.arr[c - 'a'] = new Trie();
            temp = temp.arr[c - 'a'];
        }
        if (temp != null)
            temp.isWord = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for (String str : wordDict) {
            insert(t, str);
        }

        return search(s, t);

    }

    private boolean search(String s, Trie t) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        Trie node = t;
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            node = t;
            if(!visited[i])
                continue;
            for (int j = i; j < n; j++) {
                if (node != null) {
                    node = node.arr[s.charAt(j) - 'a'];
                    if (node!=null && node.isWord) {
                        visited[j] = true;
                    }
                } else {
                    break;
                }
            }
        }
        return visited[n-1];
    }


    private boolean contains(String s, List<String> w, int i, int j) {
        return w.contains(s.substring(i, j));
    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] present = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            if (!present[i] && contains(s, wordDict, 0, i)) {
                present[i] = true;
                if (i == s.length())
                    return true;

                for (int j = i + 1; j <= s.length(); j++) {
                    if (!present[j] && contains(s, wordDict, i, j)) {
                        present[j] = true;
                    }
                    if (present[j] && j == s.length())
                        return true;
                }

            }

        }
        return false;

    }


    public static void main(String[] args) {
        WordBreak o = new WordBreak();

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] strs = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
//        System.out.println(o.wordBreak2(s, Arrays.asList(strs)));

        System.out.println(o.wordBreak2("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(o.wordBreak("bb", Arrays.asList("a","b","bbb","bbbb")));
    }

}
