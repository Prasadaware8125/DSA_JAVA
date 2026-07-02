// Time Complexity = O(n!)
// T(n) = 1Queenplace * T(n-1) + isSafe() -> O(n)
import java.util.*;
// Place N Queens on an N * N chessboard such that no 2 queens can not attack each other.
// all solutions possible
// find possible solution yes/no
// count solutions
public class NQueens {
    static int count = 0;
    public static boolean nQueens( char board[][] , int row ) {
        // Base Case
        if( row == board.length ) {
            count++; // Count all possible ways or solutions
            // printBoard(board);
            return true;
        }  

        // Column loop
        for( int j = 0 ; j <board.length ; j++ ) {
            if( isSafe(board, row, j) ) {
                board[row][j] = 'Q';
                if(nQueens(board, row+1)) {
                    return true;
                } // Function call
                board[row][j] = 'X'; // Backtracking step // for all possible solutions

            }
        }

        return false;
    }

    public static void printBoard( char board[][] ) {
        System.out.println("----- Chess Board ------");
        for( int i = 0 ; i < board.length ; i++ ) {
            System.out.print(" | ");
            for( int j = 0 ; j < board.length ; j++ ) {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe( char board[][] , int row , int col ) {
        
        // Vertical Up
        for( int i = row-1 ; i >= 0 ; i-- ) {
            if( board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left
        for( int i = row-1 , j = col-1 ; i >= 0 && j >= 0 ; i-- , j-- ) {
            if( board[i][j] == 'Q') {
                return false;
            }
        }
        // Diagonal right
        for( int i = row-1 , j = col+1 ; i >= 0 && j < board.length ; i-- , j++ ) {
            if( board[i][j] == 'Q' ) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Rows = ");
        int n = sc.nextInt();
        char board[][] = new char[n][n];

        // Initial board
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
        if( nQueens(board, 0)) {
            System.out.println("Solution is Possible");
            printBoard(board);
            System.out.println("Total ways to solve N Queens = "+count);
        } else {
            System.out.println("Solution is not possible");
        }
        sc.close();
    }
}
