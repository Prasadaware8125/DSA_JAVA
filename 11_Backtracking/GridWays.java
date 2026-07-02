// Time Complexity = O(2^(n+m)) (Exponential)
/*
 * Formula :
 * GridWays = ((n-1)!+(m-1)!) / ((n-1)!*(m-1)!)
 */
public class GridWays {
    public static int gridWays( int i , int j , int n , int m ) {
        // Base Case 
        if( i == n - 1 && j == m - 1 ) {
            return 1;
        } else if( i == n || j == m ) {
            return 0;
        }

        // Ways 
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);

        return w1 + w2;
    }
    public static void main(String[] args) {
        int n = 3, m = 4;
        System.out.println(gridWays(0, 0, n, m));
    }
}
// Output : 
/*PS D:\Git\Java\Java_Revision\Backtracking> java .\GridWays.java
6
PS D:\Git\Java\Java_Revision\Backtracking> java .\GridWays.java
10
PS D:\Git\Java\Java_Revision\Backtracking> 
 */
