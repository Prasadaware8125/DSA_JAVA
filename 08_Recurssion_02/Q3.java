// Question 3 : Write a program to find Length of a string using Recurssion.
public class Q3 {
    public static int findLength(String str , int idx ) {
        if( idx == str.length() ) {
            return idx;
        }
        return findLength(str, idx+1);
    }

    public static void main(String[] args) {
        System.out.println(findLength("PrasadAware", 0));
    }
}
