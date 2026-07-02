public class TowerOfHanoi {
    public static void toh( char source , char destination , char auxillary , int n ) {
        // Base case
        if( n == 0 )
        return;

        // Faith
        toh(source, auxillary, destination, n-1 );
        System.out.println(n+". disk move from "+source+" to "+destination);

        // Faith
        toh(auxillary, destination, source, n-1 );
    }

    public static void main(String[] args) {
        toh('A', 'C', 'B', 3);
    }
}
