public class Questions {

    public static boolean isPowerOf2( int n ) {
        return ( n & n-1) == 0;
        // eg. n = 8
        // n-1 = 7
        // 8 = 1000 and 7 = 0111
        // if n & n-1 equal to 0 then it is true else false
        // 1000 & 0001 = 0000 hence it is a power of 2
        // n = 9
        // n-1 = 8
        // 9 = 1001 and 8 = 1000
        // 1001 & 1000 = 1000 hence it is not power of two
    }

    public static int countSetBits( int n ) {
        // O(log n)
        int count = 0;
        while (n>0) {
            if( (n & 1) != 0 ) {
                count++;
            } 
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) {

        // Q1. Cheak if a number is power of 2 or not.
        // System.out.println(isPowerOf2(64)); // true
        // System.out.println(isPowerOf2(10)); // false

        // Q2. Count set bits in a number.
        System.out.println(countSetBits(16)); // 1
        System.out.println(countSetBits(15)); // 4
    }
}
