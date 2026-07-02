public class BitOperation {

    public static int getIthBit( int n , int i ) {
        int bitMask = 1 << i;
        if( ( n & bitMask ) == 0 ) {
            return 0;
        } else {
            return 1;
        }
        // eg. n = 15 and i = 2
        // 15 == 1101 
        // bitmask = 1<<i i.e 0100
        // 1101 & 0100 = 1
        // Ans = 1
    }

    public static int setIthBit( int n , int i ) {
        int bitMask = 1 << i;
        return n | bitMask;
        // eg. n = 10 and i = 2
        // 10 = 1010 and bitmask = 0100
        // 1010 | 0100 = 1110 = 14 in decimal
    }

    public static int clearIthBit( int n , int i ) {
        int bitMask = ~(1 << i);
        return n & bitMask;
        // eg. n = 10 and i = 3
        // 10 = 1010 and bitmask = 1000, compliment of bitmask = 0111
        // 1010 & 0111 = 0010 = 2 in decimal
    }

    public static int updateIthBit( int n , int i , int newBit ) {
        // if( newBit == 0 ) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;

        // eg. n = 10 , i = 3 and newBit = 0
        // 10 = 1010
        // clearIthBit(10,3) = 0010
        // bitMask = 0<<3 = 0000
        // 0010 | 0000 = 0010 = 2 in decimal 
        // for newBit = 1
        // bitMask = 1<<3 = 1000
        // 0010 | 1000 = 1010 = 10 in decimal
    }

    public static int clearLastIBits( int n , int i ) {
        int bitMask = (-1)<<i;
        return n & bitMask;
        // eg. n = 15 and i = 2
        // 15 = 1111 and bitmask = (~0)<<i = 1100 
        // 1111 & 1100 = 1100 = 12 in decimal
    }

    public static int clearRangeOfBits( int n , int i , int j ) {
        int a = ((~0)<<(j+1));
        int b = (1<<i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }
    public static void main(String[] args) {
        // Get Ith Bit
        // System.out.println(getIthBit(1, 0)); // 1
        // System.out.println(getIthBit(15, 2)); // 1
        // System.out.println(getIthBit(3, 2)); // 0

        // Set Ith Bit
        // System.out.println(setIthBit(10, 2)); // 14
        // System.out.println(setIthBit(3, 2)); // 7

        // Clear Ith Bit
        // System.out.println(clearIthBit(10, 3)); // 2
        // System.out.println(clearIthBit(10, 1)); // 8

        // Update Ith Bit
        // System.out.println(updateIthBit(15, 2, 0)); // 11
        // System.out.println(updateIthBit(10, 2, 1)); // 14

        // Clear Last I Bits
        // System.out.println(clearIthBit(15, 2)); // 12

        // Clear Range Of Bits
        System.out.println(clearRangeOfBits(10, 2, 4));
    }
}
