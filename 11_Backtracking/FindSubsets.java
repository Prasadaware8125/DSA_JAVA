import java.util.*;
// Find & print all subsets of a given string
public class FindSubsets {
    public static void findSubsets( String str, String ans, int i ) {
        // Base Case 
        if( i == str.length() ) {
            if( ans == "") {
                System.out.println("Empty"); 
            } else {
                System.out.println(ans);}
            return;
        }
        // Yes Choice
        findSubsets(str, ans+str.charAt(i), i+1);

        // No Choice
        findSubsets(str, ans, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        findSubsets(str, "", 0);
        sc.close();
    }
}
