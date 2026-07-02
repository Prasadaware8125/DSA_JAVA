// Given an input string and a dictionary of words, find out if the input string
// can be broken into a space-separated sequence of dictionary words.

// words[] = { i, like, sam, samsung, mobile, ice }
// key = "ilikesamsung"

// Output = true

// TC = O(L), where L = length of logest string
// Leetcode 139
// Medium
import java.util.HashMap;

public class Word_Break_Problem {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for( int i = 0 ; i < 26 ; i++ ) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static HashMap<String, Boolean> map = new HashMap<>();

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

    public static boolean search(String key) {
        Node curr = root;
        for( int i = 0 ; i < key.length() ; i++ ) {
            int idx = key.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if( key.length() == 0 ) return true;
        
        if( map.containsKey(key) ) {
            return map.get(key);
        }
        
        for( int i = 0 ; i <= key.length() ; i++ ) {
            if ((search(key.substring(0, i))) && wordBreak(key.substring(i))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        String[] words = { "i", "like", "sam", "samsung", "mobile", "ice" };
        
        for( String word : words ) {
            insert(word);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
