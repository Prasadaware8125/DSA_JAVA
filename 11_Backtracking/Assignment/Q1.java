/*
 * Question 1: Rat in a Maze
You are given a square maze represented as a 2D matrix of size N × N. Each cell in the maze contains either a 0 or a 1:

1 means the cell is open and the rat can move through it.

0 means the cell is blocked and the rat cannot move through it.

The rat starts at the top-left corner of the maze at position (0, 0) and its goal is to reach the bottom-right corner at position (N - 1, N - 1).

The rat can move in four possible directions:

'U' → Up (move to cell (x - 1, y))

'D' → Down (move to cell (x + 1, y))

'L' → Left (move to cell (x, y - 1))

'R' → Right (move to cell (x, y + 1))
 */
public class Q1 {
    static int count = 0;
    public static void ratInMaze( int maze[][] , int row , int col , int n , String ans ) {
        // Base Case
        if( row < 0 || col < 0 || row == n || col == n || maze[row][col] == 0 ) {
            return;
        }
        if( row == n-1 && col == n-1) {
            count++;
            // System.out.println(ans);
            printMaze(maze);
            return;
        }

        maze[row][col] = 0; // Block

        ratInMaze(maze, row-1, col, n, ans+'U');
        ratInMaze(maze, row, col-1, n, ans+'L');
        ratInMaze(maze, row+1, col, n, ans+'D');
        ratInMaze(maze, row, col+1, n, ans+'R');

        maze[row][col] = 1; // Unblock
    }

    public static void printMaze(int maze[][]) {
        System.out.println("-----Maze-----");
        for( int i = 0 ; i < maze.length ; i++ ) {
            for( int j = 0 ; j < maze[0].length ; j++ ) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 1,}
        };
        System.out.println("Original Maze : ");
        printMaze(maze);
        System.out.println("Solution : ");
        ratInMaze(maze, 0, 0, maze.length, "");
        System.out.println("Total Ways = "+count);
    }
}
