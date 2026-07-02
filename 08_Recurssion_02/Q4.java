// Question 4 : We are given a string S, we need to find the count of all contiguous substring starting and ending with same character.
public class Q4 {
    public static int findSubstring( String str , int start , int end , int count ) {
        // Base Case
        if( start >= end ) {
            return count;
        }
        // Work
        if( str.charAt(start) == str.charAt(end)) {
            count++;
        }
        findSubstring(str, start+1, end, count);
        findSubstring(str, start, end-1, count);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("abcab", 0, 5, 0));
    }
}
