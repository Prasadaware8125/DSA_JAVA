public class Flood_Fill_Algorithm {
    // TC = O(n*m)
    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol, int n, int m ) {
        if( sr < 0 || sc < 0 || sr >= n || sc >= m || image[sr][sc] != orgCol || vis[sr][sc] ) {
            return;
        }

        image[sr][sc] = color;
        vis[sr][sc] = true;
        // if( sr-1 >= 0 && sc-1 >= 0 && sr+1 < n && sc+1 < m ) {
            helper(image, sr, sc-1, color, vis, orgCol, n, m);
            helper(image, sr, sc+1, color, vis, orgCol, n, m);
            helper(image, sr+1, sc, color, vis, orgCol, n, m);
            helper(image, sr-1, sc, color, vis, orgCol, n, m);
        // }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];

        helper(image, sr, sc, color, vis, image[sr][sc], n, m);
        return image;
    }

    public static void printImage(int[][] image, int n, int m) {
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < m ; j++ ) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                        {1,1,1},
                        {1,1,0},
                        {1,0,1}
                    };
        int sr = 1, sc = 1, color = 2;
        int n = image.length;
        int m = image[0].length;
        System.out.println("Original Image ");
        printImage(image, n, m);
        int[][] res = floodFill(image, sr, sc, color);
        System.out.println("After Image ");
        printImage(res, n, m);
    }
}
