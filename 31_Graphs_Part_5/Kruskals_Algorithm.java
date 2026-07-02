import java.util.ArrayList;
import java.util.Collections;

public class Kruskals_Algorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 4;   // no. of vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for( int i = 0 ; i < n ; i++ ) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if( x == par[x] ) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if( rank[parA] == rank[parB] ) {
            par[parB] = parA;
            rank[parA]++;
        } else if( rank[parA] > rank[parB] ) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void create_graph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));

        edges.add(new Edge(1, 3, 40));

        edges.add(new Edge(2, 3, 50));
    }


    public static int kruskalsAlgorithm(ArrayList<Edge> edges) {
        init();
        Collections.sort(edges);
        int cost = 0;
        int count = 0;
        for( int i = 0 ; count<n-1 ; i++ ) {
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if( parA != parB ) {
                union(e.src, e.dest);
                cost += e.wt;
                count++;
            }
        }

        return cost;
    }
    // TC = (V+ElonE)
    // E = number of edges (E)
    // V = number of vertices (E-1)
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        create_graph(edges);
        System.out.println("Total cost to connect all edges is : "+kruskalsAlgorithm(edges));
    }
}
