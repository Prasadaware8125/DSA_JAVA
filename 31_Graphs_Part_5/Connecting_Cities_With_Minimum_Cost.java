import java.util.ArrayList;
import java.util.PriorityQueue;

// It's MST and solved by using Prim's Algorithm
public class Connecting_Cities_With_Minimum_Cost {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int p) {
            this.src = s;
            this.dest = d;
            this.wt = p;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex, cost;
        public Pair(int v, int c){
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void create_graph(int[][] cities, ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < cities.length ; i++ ) {
            int src = i;
            for( int j = 0 ; j < cities.length ; j++ ) {
                if (i != j && cities[i][j] != 0) {
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
    }

    // Adjacency List
    // TC = O(V*E)
    public static int connectingCitiesWithMinimunCost1(int[][] cities, int src) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        create_graph(cities, graph);

        int n = cities.length;
        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if( !vis[curr.vertex] ) {
                vis[curr.vertex] = true;
                cost += curr.cost;

                for( int i = 0 ; i < graph[curr.vertex].size() ; i++ ) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        return cost;
    }

    // Adjacency Matrix
    // TC = O(V*E*N)
    public static int connectingCitiesWithMinimunCost2(int[][] cities, int src) {
        
        int n = cities.length;
        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if( !vis[curr.vertex] ) {
                vis[curr.vertex] = true;
                cost += curr.cost;

                for( int i = 0 ; i < cities[curr.vertex].length ; i++ ) {
                    if(cities[curr.vertex][i] != 0) {
                        pq.add(new Pair(i, cities[curr.vertex][i]));
                    }
                }
            }
        }

        return cost;
    }

    public static int connectingCitiesWithMinimunCost3(int[][] cities) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[cities.length];

        pq.add(new Pair(0, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if( !vis[curr.vertex] ) {
                vis[curr.vertex] = true;
                cost += curr.cost;

                for( int i = 0 ; i < cities[curr.vertex].length ; i++ ) {
                    if( cities[curr.vertex][i] != 0 ) {
                        pq.add(new Pair(i, cities[curr.vertex][i]));
                    }
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        int[][] cities = {
                            {0, 1, 2, 3, 4},
                            {1, 0, 5, 0, 7},
                            {2, 5, 0, 6, 0},
                            {3, 0, 6, 0, 0},
                            {4, 7, 0, 0, 0}
                        };
        System.out.println("Connecting Cities With Minimum Cost -> Using Adjacency List = "+connectingCitiesWithMinimunCost1(cities, 0));
        System.out.println("Connecting Cities With Minimum Cost -> Using Adjacency Matrix = "+connectingCitiesWithMinimunCost2(cities, 0));
        System.out.println("Connecting Cities With Minimum Cost -> Using Direct Method = "+connectingCitiesWithMinimunCost3(cities));
    }
}