import java.util.*;

class FirstNonRepeatingLetter {
    public static void printNonRepeating(String str) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder("");
        int freq[] = new int[26];
        for( int i = 0 ; i < str.length() ; i++ ) {
            char ch = str.charAt(i);
            queue.add(ch);
            freq[ch-'a']++;
            while ( !queue.isEmpty() && freq[queue.peek()-'a'] > 1 ) {
                queue.remove();
            }

            if( queue.isEmpty() ) {
                res.append("-1");
            } else {
                res.append(queue.peek());
            }
        }


        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
    
}