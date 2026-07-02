public class ShortestPath {

    public static float findSortestPath(String path) {
        int x = 0, y = 0;
        for( int i = 0 ; i < path.length() ; i++ ) {
            // North
            if( path.charAt(i) == 'N') {
                y++;
            } 
            // South
            else if( path.charAt(i) == 'S') {
                y--;
            }
            // West
            else if( path.charAt(i) == 'W') {
                x--;
            }
            // East
            else {
                x++;
            }
        }
        return (float)Math.sqrt((x*x)+(y*y));
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        // String path = "NS";
        System.out.println("Sortest Path = "+findSortestPath(path));
    }
}
