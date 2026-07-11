// Climbing Stairs
// Count ways to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time.
// Recursion
import java.util.Scanner;

public class Climbing_Stairs_Recursion {
    public static int climbingStairs(int n) {
        if( n == 0 ) {
            return 1;
        } else if( n < 0 ) {
            return 0;
        }

        return climbingStairs(n-1) + climbingStairs(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Stairs: ");
        int n = sc.nextInt();
        System.out.println(climbingStairs(n));
        sc.close();
    }
}
