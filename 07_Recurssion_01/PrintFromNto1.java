public class PrintFromNto1 {

    public static void printNumbers(int n) {
        // Base Case
        if( n == 1 ) {
            System.out.print(n);
            return;
        }
        // Work
        System.out.print(n+" ");
        // Inner Call
        printNumbers(n-1);
    }
    public static void main(String[] args) {
        printNumbers(10);
    }
}
