import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Cheapest_Flights_Within_K_Steps_Using_Dijekstra_With_Adjacency_Matrix {
    static class Info {
        int v, c, s; // vertex, cost, stops
        public Info(int v, int c, int s) {
            this.v = v;
            this.c = c;
            this.s = s;
        }
    }

    public static int cheapestFlightsWithinKStpes(int[][] flights, int n, int src, int dest, int k) {
        int[] dist = new int[n];
        for( int i = 0 ; i < n ; i++ ) {
            if( i != src ) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if( curr.s > k ) {
                break;
            }
            for( int i = 0 ; i < flights.length ; i++ ) {
                
                int u = flights[i][0];
                int v = flights[i][1];
                int wt = flights[i][2];

                if( curr.v == u &&  curr.c + wt < dist[v] ) {
                    dist[v] = curr.c + wt;
                    q.add(new Info(v, dist[v], curr.s+1));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                            {0, 1, 100},
                            {1, 2, 100},
                            {1, 3, 600},
                            {2, 0, 100},
                            {2, 3, 200}
                          };
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlightsWithinKStpes(flights, n, src, dest, k));
    }
}
