// Climbing Stairs
// Count ways to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time.
// Tabulation (Bottom Up)
import java.util.Scanner;

public class Climbing_Stairs_Tabulation {
    public static int climbingStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i = 1 ; i < n+1 ; i++ ) {
            if( i == 1 ) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs : ");
        int n = sc.nextInt();
        System.out.println(climbingStairs(n));
        sc.close();
    }
}
