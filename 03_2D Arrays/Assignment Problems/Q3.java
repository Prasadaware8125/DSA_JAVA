//Question 3 :Write a program to FindTransposeofa Matrix.What is Transpose?Transpose of a matrix is the process ofswapping therows to columns. For a 2x3 matrix,
// Matrix
// a11    a12    a13
// a21    a22    a23
// Transposed Matrix
// a11    a21
// a12    a22
// a13    a23
public class Q3 {
    public static void printmatrix(int matrix[][]) {
        for(int i = 0 ; i < matrix.length ; i++ ) {
            for( int j = 0 ; j < matrix[0].length ; j++ ) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void trasposeOfMatrix(int matrix[][]) {
        int c[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0 ; i < matrix.length ; i++ ) {
            for( int j = 0 ; j < matrix[0].length-1 ; j++ ) {
                c[j][i] = matrix[i][j];
                // matrix[i][j] = c[i][j];
            }
        }
        System.out.println("Transposed Matrix : ");
        printmatrix(c);
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6}};
        System.out.println("Original Matrix : ");
        printmatrix(matrix);
        trasposeOfMatrix(matrix);
    }
}
