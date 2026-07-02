// Remove Duplicates in a String
public class RemoveDuplicatesInAString {

    public static void removeDuplicates( String str , int idx , StringBuilder newStr , boolean map[] ) {
        // Base Case
        if( idx == str.length() ) {
            System.out.println(newStr);
            return;
        }
        // Work 
        char currChar = str.charAt(idx);
        if( map[currChar-'a'] == true) {
            // Duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        String str = "apnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
