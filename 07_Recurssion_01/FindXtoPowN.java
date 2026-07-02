// Time Complexity = O(n)
public class FindXtoPowN {
    public static int pow( int x , int n ) {
        if( n == 0 ) {
            return 1;
        }
        return x * pow(x, n-1);
    }

// Time Complexity = O(logn)
public static int powOptimized( int x , int n ) {
    // Base Case 
    if( n == 0 ) {
        return 1;
    }
    // Work
    int pow = 1;
    int halfPower = powOptimized(x, n/2);
    if( n % 2 == 0 ) {
        pow = halfPower * halfPower;
    } else {
        pow = x * halfPower * halfPower;
    }
    // Return
    return pow;
}
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(powOptimized(x,n));
    }
}
