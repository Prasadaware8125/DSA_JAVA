import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Steps_Using_Dijekstra_With_Adjacency_List {
    static class Edge {
        int src, dest, price;
        public Edge(int s, int d, int p) {
            this.src = s;
            this.dest = d;
            this.price = p;
        }
    }

    static class Info {
        int v, c, s; // vertex, cost, stops
        public Info(int v, int c, int s) {
            this.v = v;
            this.c = c;
            this.s = s;
        }
    }

    public static int cheapestFlightsWithinKStpes(int[][] flights, int n, int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        create_graph(flights, graph);

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
            for( int i = 0 ; i < graph[curr.v].size() ; i++ ) {
                Edge e = graph[curr.v].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.price;

                if( curr.c + wt < dist[v] && curr.s <= k ) {
                    dist[v] = curr.c + wt;
                    q.add(new Info(e.dest, dist[v], curr.s+1));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void create_graph(int[][] flights, ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < flights.length ; i++ ) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            Edge e = new Edge(src, dest, price);
            graph[src].add(e);
        }
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
