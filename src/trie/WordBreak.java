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
            if(temp.arr[c - 'a']==null)
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
//        int[] freq = new int[s.length() + 1];
        Trie temp = t;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int k = 0; k < s.length(); k++) {
            temp = t;
            for (int i = k; i < s.length(); i++) {
                Trie temp2 = temp.arr[s.charAt(i) - 'a'];
                if (temp2 != null) {
                    temp = temp2;
                    if (temp2.isWord) {
                        m.put(k + 1, m.getOrDefault(k + 1, new ArrayList<>()));
                        m.get(k + 1).add(i + 1);
                    }
                } else {
                    break;
                }
            }
        }
        List<Integer> idx = m.get(1);
        if (idx == null) {
            return false;
        }
        f = false;
        foo(m, 1, s.length());
        return f;

    }

    private void foo(Map<Integer, List<Integer>> m, int i, int n) {
        if (f)
            return;
        List<Integer> idx = m.get(i);
        if (idx != null) {
            if (idx.contains(n))
                f = true;
            for (int a : idx) {
                foo(m, a + 1, n);
            }
        }
    }


    private boolean contains(String s, List<String> w, int i, int j){
        return w.contains(s.substring(i,j));
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
        String[] strs = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        System.out.println(o.wordBreak2(s, Arrays.asList(strs)));

        System.out.println(o.wordBreak2("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(o.wordBreak("bb", Arrays.asList("a","b","bbb","bbbb")));
    }

}
