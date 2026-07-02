public class SearchInSortedMatrix2 {

    public static boolean staircaseSearch( int[][] matrix, int target ) {
        int row = matrix.length-1;
        int col = 0;
        while( row >= 0 && col < matrix[0].length ) {
            if( matrix[row][col] == target ) {
                System.out.println("Found at : "+row+", "+col+" index");
                return true;
            } else if( matrix[row][col] < target ) {
                col++;
            } else {
                row--;
            }
        }
        System.out.println("key not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                            {10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}
                         };
        // System.out.println(search(matrix, 10));
        staircaseSearch(matrix, 50);
        staircaseSearch(matrix, 31);
    }
}