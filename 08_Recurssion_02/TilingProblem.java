// Given a 2 x n floor and tiles of size 2 x 1, count the number of ways to tile the given board using the 2 x 1 tiles.
// (A tile can either be placed horizontally or vertically.)
// *Finding number of ways to be used to fill the floor.
public class TilingProblem {

    public static int tilingProblem( int n ) {
        // Base Case 
        if( n == 0 || n == 1 ) {
            return 1;
        }
        // Work

        // Vertical tiling approach
        // int fmn1 = tilingProblem(n-1);

        // // Horizontal tiling approach
        // int fmn2 = tilingProblem(n-2);

        // //  Total Tiles / ways
        // int totways = fmn1 + fmn2;

        // // Return statement
        // return totways;

        // Simple return statment
        return tilingProblem(n-1) + tilingProblem(n-2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(tilingProblem(n));
    }
}
