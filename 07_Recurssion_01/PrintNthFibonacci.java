public class PrintNthFibonacci {
    public static int printFibonacci(int n ) {
        // Base Case
        if( n == 1 || n == 0 ) {
            return n;
        }
        // Work
        int nM1 = printFibonacci(n-1);
        int nM2 = printFibonacci(n-2);
        int fib = nM1 + nM2;
        // return 
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(printFibonacci(25));
    }
}
