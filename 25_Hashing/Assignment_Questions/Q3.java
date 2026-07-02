// Sort by Frequency
// Given a string s, sort it in decreasing order based on the frequency of the characters. The
// frequency of a character is the number of times it appears in the string.
// Return the sorted string. If there are multiple answers, return any of them.
// Sample Input 1 : s = "cccaaa"
// Sample Output 1 : "aaaccc"
// Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Sample Input 2 : s = "tree"
// Sample Output 2 :"eert"
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

import java.util.HashMap;
public class Q3 {
    public static void sort_by_frequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for( int i = 0 ; i < s.length() ; i++ ) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        System.out.println(map);
    }
    public static void main(String[] args) {
        String s = "aaaccc";
        String s2 = "tree";
        sort_by_frequency(s);
    }
}
