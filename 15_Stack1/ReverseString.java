import java.util.Stack;
import java.util.Scanner;
public class ReverseString {

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for( int i  = 0 ; i < str.length() ; i++ ) {
            s.push(str.charAt(i));
        }
        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        return res.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        System.out.println("Original String : "+str);
        System.out.println("Reversed String : "+reverseString(str));
        sc.close();
    }
}
