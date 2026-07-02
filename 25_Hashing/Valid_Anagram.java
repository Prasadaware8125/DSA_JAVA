// Given two Strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearanging the letters of a different word or phrase, 
// typically using all the original letters exactly once.
// TC = O(n)
// SC = O(n)

import java.util.HashMap;
public class Valid_Anagram {

    public static boolean isValidAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for ( int i = 0 ; i < s.length() ; i++ ) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for( int i = 0 ; i < t.length() ; i++ ) {
            char curr = t.charAt(i);
            if( map.containsKey(curr)) {
                if( map.get(curr) == 1 ) {
                    map.remove(curr);
                } else {
                    map.put(curr, map.get(curr)-1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "heart";
        String t = "earth";
        System.out.println(isValidAnagram(s, t));
    }    
}
