// Longest Word With All Prefixes

// Find the longest string in words such that every prefix of it also in words.

// words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"}

// Answer => apple

// TC = O(L) L = longest string in words

public class Longest_Word_With_All_Prefixes {
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

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if( root == null ) {
            return;
        }

        for( int i = 0 ; i < 26 ; i++ ) {
            if( root.children[i] != null && root.children[i].eow == true ) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                if( temp.length() > ans.length() ) {
                    ans = temp.toString();
                }

                // Recursive calls
                longestWord(root.children[i], temp);
                // Backtracking
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for (String word : words) {
            insert(word);
        }

        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }
}
