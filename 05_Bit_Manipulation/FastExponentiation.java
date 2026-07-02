import java.util.*;
public class FastExponentiation {
// Google
    public static long fastExpo( int a , int n ) {
        long ans = 1;

        while( n > 0 ) {
            if( ( n & 1 ) != 0 ) { // check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }

        return ans;
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fastExpo(5, 100000));
        sc.close();
    }
}
