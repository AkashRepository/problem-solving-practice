package graph;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadderTwo {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int n = wordList.size();
        q.add(beginWord);
        int[] vi = new int[n];
        Arrays.fill(vi,-1);

        List<List<String>> out = new ArrayList<>();
        int endWordIdx = getIdx(endWord, wordList);
        int beginWordIdx = getIdx(beginWord, wordList);

        if(endWordIdx==-1)
            return out;

        if(beginWordIdx!=-1)
            vi[beginWordIdx] = -2;

        boolean f = false;
        while (!q.isEmpty() && !f) {
            int size = q.size();
            System.out.println(q.toString());

            while (size-- > 0) {
                String u = q.poll();

                for (int i = 0; i < n; i++) {
                    if (vi[i]==-1 && isEqual(u, wordList.get(i))) {

                        int idx = getIdx(u, wordList);
                        vi[i] = idx==-1?-2:idx;

                        if(wordList.get(i).equals(endWord)){
                            List<String> temp = new ArrayList<>();
                            temp.add(endWord);
                            while(idx>=0){
                                temp.add(wordList.get(idx));
                                idx = vi[idx];
                            }
                            temp.add(beginWord);
                            out.add(temp);
                            vi[i] = -1;
                            f = true;
                        } else {
                            q.add(wordList.get(i));
                        }
                    }
                }
            }
        }
        return out;
    }

    private boolean isEqual(String u, String b) {
        boolean f = false;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != b.charAt(i)) {
                if (f)
                    return false;
                f = true;
            }
        }
        return f;
    }

    private int getIdx(String s, List<String> wordList){
        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(s)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        WordLadderTwo o = new WordLadderTwo();
        System.out.println(o.findLadders2("hit",
                "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }


    class Node {
        Node[] arr;
        char c;
        String word;
        boolean isWord;

        public Node(char c){
            this.c=c;
            this.arr = new Node[26];
        }
    }

    private void insert(Node root, String s){
        Node node = root;

        for(char c: s.toCharArray()){
            int idx = c-'a';
            if(node.arr[idx]==null){
                node.arr[idx] = new Node(c);
            }
            node = node.arr[idx];
        }
        node.isWord = true;
        node.word = s;
    }

    private void search(char[] c, int i, int idx, int n, Node node, Node root, String target, List<String> list){

        if(node==null)
            return;
        if(i>n)
            return;
        if(node.isWord){
            search(root, node.word, target, list);
            return;
        }

        if(i!=idx){
            search(c, i+1, idx, n, node.arr[c[i]-'a'], root, target, list);
        } else {
            for(Node nn : node.arr){
                search(c, i+1, idx, n, nn, root, target, list);
            }
        }
    }


    private void search(Node root, String word, String target, List<String> list) {

        int n = word.length();

        if(word.equals(target)){
            list.add(target);
            v.add(target);
            out.add(new ArrayList<>(list));
            return;
        }
        ArrayList<String> arrayToList = new ArrayList<>();
        List<String> filteredList = arrayToList.stream().filter(str -> !str.equals("")).collect(Collectors.toList());
        arrayToList = new ArrayList<>(filteredList);
        
        list.add(word);
        v.add(word);
        for(int i=0;i<n;i++){
            char[] c = word.toCharArray();
            search(c, 0, i, n, root, root, target, list);
        }
        list.remove(list.size()-1);
        v.remove(word);

    }

    HashSet<String> v;
    List<List<String>> out = new ArrayList<>();

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        v = new HashSet<>(size);
        Node root = new Node('/');

        for(String word: wordList){
            insert(root, word);
        }

        List<String> list = new ArrayList<>();
        search(root, beginWord, endWord, list);
        return out;
    }

}
