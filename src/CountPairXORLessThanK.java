import java.util.Arrays;

public class CountPairXORLessThanK {


    // Structure of Trie
    static class TrieNode {
        // Stores binary represention
// of numbers
        TrieNode child[] = new TrieNode[2];

        // Stores count of elements
// present in a node
        int cnt;

        // Function to initialize
// a Trie Node
        TrieNode() {
            child[0] = child[1] = null;
            cnt = 0;
        }

        @Override
        public String toString() {
            return "(" +
                    ",c=" + cnt +
                    "[0]=" + child[0] +
                    ",[1]=" + child[1] +
                    ")";
        }
    }

    ;


    // Function to insert a number
// into Trie
    static void insertTrie(TrieNode root,
                           int N) {
// Traverse binary representation
// of X
        for (int i = 31; i >= 0; i--) {
            // Stores ith bit of N
            int x = (N) & (1 << i);
            System.out.print(x);
            // Check if an element already
            // present in Trie having ith
            // bit x
            if (x < 2 && root.child[x] ==
                    null) {
                // Create a new node of
                // Trie.
                root.child[x] = new TrieNode();
            }

            // Update count of elements
            // whose ith bit is x
            if (x < 2)
                root.child[x].cnt += 1;

            // Update root
            if (x < 2)
                root = root.child[x];
        }
        System.out.println();
    }

    // Function to count elements
// in Trie whose XOR with N
// less than K
    static int cntSmaller(TrieNode root,
                          int N, int K) {
// Stores count of elements
// whose XOR with N less
// than K
        int cntPairs = 0;

// Traverse binary
// representation of N
// and K in Trie
        for (int i = 31; i >= 0 &&
                root != null; i--) {
            // Stores ith bit of N
            int x = (N & (1 << i));

//            System.out.print(x);
            // Stores ith bit of K
            int y = (K & (1 << i));

            // If the ith bit of K
            // is 1
            if (y == 1) {
                // If an element already
                // present in Trie having
                // ith bit (x)
                if (root.child[x] != null) {
                    cntPairs +=
                            root.child[x].cnt;
                }

                root = root.child[1 - x];
            }

            // If the ith bit of K is 0
            else {
                // Update root
                if (x < 2)
                    root = root.child[x];
            }
        }
        return cntPairs;
    }

    // Function to count pairs that
// satisfy the given conditions
    static int cntSmallerPairs(int arr[],
                               int N, int K) {
// Create root node of Trie
        TrieNode root = new TrieNode();

// Stores count of pairs that
// satisfy the given conditions
        int cntPairs = 0;

// Traverse the given array
        for (int i = 0; i < N; i++) {
            // Update cntPairs
            cntPairs += cntSmaller(root,
                    arr[i], K);

            // Insert arr[i] into Trie
            insertTrie(root, arr[i]);
//            System.out.println(root);
        }
        return cntPairs;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8};
        int K = 2;
        int N = arr.length;
        System.out.print(cntSmallerPairs(arr, N, K));
    }
}


