// O(n^3)
public class PrintSubArrays {
    public static void printSubArrays(int num[]) {
        int totalSubArrays = 0;
        int sum;
        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i<num.length ; i++ ) {
            for( int j = i ; j<num.length ; j++ ) {
                sum = 0;
                for( int k = i ; k <= j ; k++ ) {
                    System.out.print(num[k]+" ");
                    sum += num[k];
                }
                // System.out.println(sum);
                System.out.println();
                totalSubArrays++;
                if( max < sum ) {
                    max = sum;
                }
            }
            System.out.println();
        }
        System.out.println("Total Sub Arrays ="+totalSubArrays);
        System.out.println("Largest subarray ="+max);
    }
    public static void main(String[] args) {
        int num[] = {1,-2,6,-1,3};
        printSubArrays(num);
    }
}
