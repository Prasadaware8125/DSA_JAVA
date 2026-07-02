public class PrintFrom1toN {

    public static void printIncreasing( int n ) {
        // Base Case
        if( n == 1 ) {
            System.out.print(n+" ");
            return;
        }
        // Inner Call
        printIncreasing(n-1);
        // Work
        System.out.print(n+" ");
    }
    public static void main(String []args) {
        printIncreasing(10);
    }
}
