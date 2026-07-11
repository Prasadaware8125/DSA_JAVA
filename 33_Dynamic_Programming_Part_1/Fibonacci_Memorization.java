import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci_Memorization {
    public static int fib(int n, int[] dp) {
        if( n == 0 || n == 1 ) {
            return n;
        }

        if( dp[n] != -1 ) {
            return dp[n];
        }

        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fib(n, dp));
        sc.close();
    }
}
