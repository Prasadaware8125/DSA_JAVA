import java.util.Stack;
public class DuplicateParentheses {
// Google and Microsoft interview question
// Time complexity = O(n)
    
    public static boolean isDuplicateParentheses( String str ) {
        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < str.length() ; i++ ) {
            char curr = str.charAt(i);
            // closing
            if( curr == ')') {
                int count = 0;
                while ( stack.pop() != '(' ) {
                    count++;
                }
                if( count < 1 ) {
                    return true;    // found duplicate parenthesis
                }
            } else {    // Opening , operator , operands
                stack.push(curr);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b)+(c+d))";
        String str2 = "((a+b))";
        System.out.println("String : "+str1);
        System.out.println("Duplicate paranthesis : "+isDuplicateParentheses(str1));
        System.out.println("String : "+str2);
        System.out.println("Duplicate paranthesis : "+isDuplicateParentheses(str2));
    }
}
