package graph;

import java.util.*;

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
        System.out.println(o.findLadders("hit",
                "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

}
