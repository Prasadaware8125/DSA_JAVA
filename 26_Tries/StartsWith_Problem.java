// StartsWith Problem
// Create function boolean startsWith(String prefix) for a trie.
// Returns true if there is a previously inserted string word that has the prefix, & false otherwise.

// TC = O(n)
public class StartsWith_Problem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for( int i = 0 ; i < 26 ; i++ ) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for( int i = 0 ; i < word.length() ; i++ ) {
            int idx = word.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // O(n)
    public static boolean startsWith(String prefix) {
        Node curr = root;

        for( int i = 0 ; i < prefix.length() ; i++ ) {
            int idx = prefix.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "mango", "man", "woman" };

        for (String word : words) {
            insert(word);
        }

        String prefix = "app";
        System.out.println(startsWith(prefix));
    }
}
