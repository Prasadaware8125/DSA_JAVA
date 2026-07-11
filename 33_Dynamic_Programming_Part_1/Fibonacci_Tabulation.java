import java.util.Scanner;

public class Fibonacci_Tabulation {
    public static int fib(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;

        for( int i = 1 ; i < dp.length ; i++ ) {
            if( i == 1 ) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println(fib(n));
        sc.close();
    }
}
