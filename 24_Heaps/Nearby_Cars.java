import java.util.PriorityQueue;

public class Nearby_Cars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int i;
        int distSq;

        Point(int i, int x, int y, int distSq) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][] res = new int[k][2];
        for( int i = 0 ; i < points.length ; i++ ) {
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(i, points[i][0], points[i][1], distSq));
        }

        for(int i = 0 ; i < k ; i++ ) {
            res[i][0] = pq.peek().x;
            res[i][1] = pq.peek().y;
            pq.remove();
        }
        return res;
    } 
    
    public static void main(String[] args) {
        int[][] points = {
            {3, 3}, 
            {5, -1},
            {-2, 4}
        };
        int k = 2;
        int res[][] = kClosest(points, k);
        for( int i = 0 ; i < res.length ; i++ ) {
            System.out.println("("+res[i][0]+","+res[i][1]+")");
        }
    }
}