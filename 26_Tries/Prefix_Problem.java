// Microsoft & Google
// Hard

// Find shortest unique prefix for every word in a given list.
// Assume no word is prefix of another.

// arr[] = { "zebra", "dog", "duck", "dove"}
// and => {"z", "dog", "du", "dov"}


// TC = O(L), where L = length of longest String

import java.util.ArrayList;

public class Prefix_Problem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq = 0;

        Node() {
            for( int i = 0 ; i < 26 ; i++ ) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for( int i = 0 ; i < word.length() ; i++ ) {
            int idx = word.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // public static String check(String word) {
    //     Node curr = root;
    //     StringBuilder str = new StringBuilder();
    //     for( int i = 0 ; i < word.length() ; i++ ) {
    //         int idx = word.charAt(i) - 'a';
    //         while( curr.freq != 1 ) {
    //             str.append(word.charAt(i));
    //             curr.freq--;
    //             // curr = curr.children[idx];
    //         }
    //         return str.toString();
    //     }

    //     return str.toString();
    // }

    // public static String[] prefixProblem(String[] arr) {
    //     String[] res = new String[arr.length];
    //     for( int i = 0 ; i < arr.length ; i++ ) {
    //         String word = check(arr[i]);
    //         res[i] = word;
    //     }
    //     return res;
    // }

    public static void findPrefix(Node root, String ans, ArrayList<String> res) {
        if( root == null ) return;

        if( root.freq == 1 ) {
            res.add(ans);
            System.out.println(ans);
            return;
        }
        for( int i = 0 ; i < root.children.length ; i++ ) {
            if( root.children[i] != null ) {
                findPrefix(root.children[i], ans+(char)(i+'a'), res);
            }
        }
    }
    public static void main(String[] args) {
        String[] arr = { "zebra", "dog", "duck", "dove"};
        for( String word : arr ) {
            insert(word);
        }
        // String[] ans = prefixProblem(arr);
        // for( String word : ans ) {
        //     System.out.println(word);
        // }
        root.freq = -1;
        ArrayList<String> res = new ArrayList<>();
        findPrefix(root, "", res);
        System.out.println(res);
        
    }
}
