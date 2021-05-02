package trie;

public class WordFilter {



    class Node { // Trie node
        char c;
        Node[] nodes;
        int idx; // to keep track of maximum word index which end at this node

        public Node(char c){
            this.c=c;
            this.nodes = new Node[27]; // 26 lower-case alphabet + '#' character
            this.idx = -1;
        }
    }

    int search(Node node, String s) {
        Node n = node;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (c == '#') {
                idx = 26;
            }
            if (n.nodes[idx] != null) {
                n = n.nodes[idx];
            } else {
                return -1;
            }
        }
        return n.idx;
    }

    void insert(Node node, String s, int idx) {
        Node n = node;
        StringBuilder sb = new StringBuilder('#' + s);
        boolean f = false; // flag to only add index in node once past '#' character
        for (int i = s.length()-1; i >=0; i--) {
            String temp = sb.insert(0, s.charAt(i)).toString();
            n = node;
            f = false;
            for (char c : temp.toCharArray()) {
                if(f){
                    n.idx = Math.max(n.idx, idx);
                }
                int index = c - 'a';
                if (c == '#') {
                    f = true;
                    index = 26;
                }
                if (n.nodes[index] == null) {
                    n.nodes[index] = new Node(c);
                }
                n = n.nodes[index];
            }
            if(f){
                n.idx = Math.max(n.idx, idx);
            }
        }

    }


    Node prefixTrie;

    public WordFilter(String[] words) {
        this.prefixTrie = new Node('/');
        int idx = 0;
        for(String s: words){
            insert(this.prefixTrie, s, idx++);
        }

    }

    public int f(String prefix, String suffix) {
        return search(this.prefixTrie, suffix+"#"+prefix);
    }

    public static void main(String[] args) {

        WordFilter o = new WordFilter(
                new String[]{
                        "abcaccbcaa"
                });

        System.out.println(o.f("ab", "abcaccbcaa"));
    }
}
