import java.util.*;
public class PrintFactorialOfN {

    public static long printFactorial(int n) {
        // Base Case
        if( n == 1 ) {
            return 1;
        }
        // Work
        long fact = 1;
        fact = n * printFactorial(n-1);
        // Inner Call
        return fact;
    }
    public static void main(String []agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to find it's Factorial : ");
        int n = sc.nextInt();
        long fact = printFactorial(n);
        System.out.println("Factorial of "+ n +" is "+fact);
        sc.close();
    }
} 
