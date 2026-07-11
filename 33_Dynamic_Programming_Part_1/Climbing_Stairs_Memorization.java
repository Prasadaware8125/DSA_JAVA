// Climbing Stairs
// Count ways to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time.
// Memorization (Top Down)
import java.util.Arrays;
import java.util.Scanner;

public class Climbing_Stairs_Memorization {
    public static int climbingStairsUtil(int n, int[] dp) {
        if( n < 0 ) {
            return 0;
        } else if( n == 0 ) {
            return 1;
        }

        if( dp[n] != -1 ) {
            return dp[n];
        }

        return dp[n] = climbingStairsUtil(n-1, dp) + climbingStairsUtil(n-2, dp);
    }

    public static int climbingStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbingStairsUtil(n, dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Stairs : ");
        int n = sc.nextInt();
        System.out.println(climbingStairs(n));;
        sc.close();
    }
}
