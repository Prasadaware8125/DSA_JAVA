// Question 2 :You are given a number (eg -  2019), convert it into a String of english like“two zero one nine”.  Use a recursive function to solve this problem.NOTE-Thedigitsofthenumberwillonlybeintherange0-9andthelastdigitofanumbercan’t be 0.Sample Input: 1947Sample Output: “one nine four seven”
public class Q2 {
    static String num[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void convertToString( int n ) {
        // Base Case
        if( n == 0 ) {
            return;
        }
        // Work
        int lastDigit = n%10;
        convertToString(n/10);
        System.out.print(num[lastDigit]+" ");
    }

    public static void main(String[] args) {
        convertToString(2005);
    }
}
