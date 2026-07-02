import java.util.*;
public class UpperCase {

    public static String toUpperCase(String sentence) {
        StringBuilder str = new StringBuilder("");
        str.append(Character.toUpperCase(sentence.charAt(0)));
        for( int i = 1 ; i < sentence.length() ; i++ ) {
            if( sentence.charAt(i) == ' ' && i < sentence.length()-1) {
                str.append(sentence.charAt(i));
                i++;
                str.append(Character.toUpperCase(sentence.charAt(i)));
            } else {
                str.append(sentence.charAt(i));
            }
        }

        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sentence : ");
        String sentence = sc.nextLine();
        System.out.println(toUpperCase(sentence));
        sc.close();
    }
}
