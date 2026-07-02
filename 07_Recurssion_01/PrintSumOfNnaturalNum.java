public class PrintSumOfNnaturalNum {
    public static int printSum( int n ) {
        // Base Case 
        if( n == 1 ) {
            return 1;
        }
        // Work
        int sum = 0;
        sum = n + printSum(n-1);
        // Inner Call or return 
        return sum;
    }
    
    public static void main(String args[]) {
        System.out.println(printSum(10));
    }
}
