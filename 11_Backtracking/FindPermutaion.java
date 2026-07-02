// Time Complexity = O(n*n!)
public class FindPermutaion {
    public static void findPermutation( String str, String ans ) {
        // Base Case 
        if( str.length() == 0 ) { // after adding all possible combinations
            System.out.println(ans); //print the ans
            return;
        }
        // Kaam
        for( int i = 0 ; i < str.length() ; i++ ) {
            char currChar = str.charAt(i); // getting character to add in new string i.e ans
            String NewStr = str.substring(0, i) + str.substring(i+1); // Removing the added character from string
            findPermutation(NewStr, ans+currChar); // Recurssive Call
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}

// Output : 
// abc
// acb
// bac
// bca
// cab
// cba
