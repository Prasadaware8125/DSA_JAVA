// Count Unique Substring
// Given a string of length n  of lowercase 
// alphabet characters, we need to 
// count total number of distinct substrings of this string.


public class Count_Unique_Substrings {
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

    public static int countNodes(Node root) {
        if( root == null ) {
            return 0;
        }

        int count = 0;

        for( int i = 0 ; i < 26 ; i++ ) {
            if( root.children[i] != null ) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    public static void main(String[] args) {
        String word = "ababa";

        for( int i = 0 ; i <= word.length()  ; i++ ) {
            String suffix = word.substring(i);
            insert(suffix);
        }

        System.out.println("Number of unique substrings are : "+countNodes(root));
    }
}
