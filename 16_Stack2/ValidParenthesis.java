import java.util.*;
public class ValidParenthesis {
// Time Complexity = O(n)
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < str.length() ; i++ ) {
            char curr = str.charAt(i);
            if( curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if( stack.isEmpty() ) {
                    return false;
                }
                if( stack.peek() == '(' && curr == ')' ||
                     stack.peek() == '{' && curr == '}' || 
                     stack.peek() == '[' && curr == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if( stack.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "][{}()]";
        System.out.println(str);
        System.out.println(isValid(str));
    }
}
